package cn.itcast.biz.impl;

import cn.itcast.biz.IOrdersBiz;
import cn.itcast.dao.IEmpDao;
import cn.itcast.dao.IOrdersDao;
import cn.itcast.dao.ISupplierDao;
import cn.itcast.erp.entity.Orderdetail;
import cn.itcast.erp.entity.Orders;
import cn.itcast.exception.ErpException;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdersBiz extends BaseBiz<Orders> implements IOrdersBiz {
    private IOrdersDao ordersDao;
    private IEmpDao empDao;
    private ISupplierDao supplierDao;

    public void setOrdersDao(IOrdersDao ordersDao) {
        this.ordersDao = ordersDao;
        super.setBaseDao(this.ordersDao);
    }

    public void setEmpDao(IEmpDao empDao) {
        this.empDao = empDao;
    }

    public void setSupplierDao(ISupplierDao supplierDao) {
        this.supplierDao = supplierDao;
    }

    @Override
    public void add(Orders orders) {
        //设置订单的状态
        orders.setState(orders.STATE_CREATE);
        //订单类型
        orders.setType(orders.TYPE_IN);
        //下单时间
        orders.setChecktime(new Date());

        //合计金额
        double total = 0;

        for(Orderdetail detali : orders.getOrderDetails()){
            //累计金额
            total += detali.getMoney();
            //明细的状态
            detali.setState(Orderdetail.STATE_NOT_IN);
            //跟订单的关系
            detali.setOrders(orders);
        }
        //设置订单的总金额
        orders.setTotalmoney(total);
        //保存到DB
        ordersDao.add(orders);
    }

    @Override
    public List<Orders> getListByPage(Orders orders1, Orders orders2, Object param, int firstResult, int maxResults) {
        //获取分页后的订单列表
        List<Orders> ordersList = super.getListByPage(orders1,orders2,param,firstResult,maxResults);
        //缓存员工编号与员工名称
        Map<Long,String> empNameMap = new HashMap<Long,String>();
        Map<Long,String> supplierNameMap = new HashMap<Long, String>();
        //循环，获取员工的名称
        for(Orders o: ordersList){
            //从缓存中取出员工名称
           o.setCreaterName(getEmpName(o.getCreater(),empNameMap));
           o.setCheckerName(getEmpName(o.getChecker(),empNameMap));
           o.setStarterName(getEmpName(o.getStarter(),empNameMap));
           o.setStarterName(getEmpName(o.getEnder(),empNameMap));

           //供应商
            o.setSupplierName(getSupplierName(o.getSupplieruuid(),supplierNameMap));
        }
        return ordersList;
    }

    public void doCheck(Long uuid, Long empUuid) {
        //1.修改订单状态
        //2.审核时间
        //3.审核人
        //获取订单，进入持久化状态
        Orders orders = ordersDao.get(uuid);
        if(!Orders.STATE_CREATE.equals(orders.getState())){
            throw new ErpException("亲！该订单已经审核过了");
        }
        //修改订单的状态
        orders.setState(Orders.STATE_CHECK);
        //审核时间
        orders.setChecktime(new Date());
        //审核人
        orders.setChecker(empUuid);
    }

    /**
     * 获取员工名称
     * @param uuid 员工编号
     * @param empNameMap 缓存员工编号与员工的名称
     * @return 返回员工名称
     */
    private String getEmpName(Long uuid, Map<Long, String> empNameMap){
        if(null == uuid){
            return null;
        }
        //从缓存中根据员工编号取出员工名称
        String empName = empNameMap.get(uuid);
        if(null == empName){
            //如果没有找员工的名称，则进行数据库查询
            empName = empDao.get(uuid).getName();
            //存入缓存中
            empNameMap.put(uuid, empName);
        }
        return empName;
    }

    /**
     * 获取供应商名称
     * @param uuid 供应商编号
     * @param supplierNameMap 缓存供应商编号与供应商的名称
     * @return 返回供应商名称
     */
    private String getSupplierName(Long uuid, Map<Long, String> supplierNameMap){
        if(null == uuid){
            return null;
        }
        String supplierName = supplierNameMap.get(uuid);
        if(null == supplierName){
            //如果没有找供应商的名称，则进行数据库查询
            supplierName = supplierDao.get(uuid).getName();
            //存入缓存中
            supplierNameMap.put(uuid, supplierName);
        }
        return supplierName;
    }

}
