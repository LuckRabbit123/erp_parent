package cn.itcast.biz.impl;

import cn.itcast.biz.IOrdersBiz;
import cn.itcast.dao.IOrdersDao;
import cn.itcast.erp.entity.Orderdetail;
import cn.itcast.erp.entity.Orders;

import java.util.Date;

public class OrdersBiz extends BaseBiz<Orders> implements IOrdersBiz {
    private IOrdersDao ordersDao;

    public void setOrdersDao(IOrdersDao ordersDao) {
        this.ordersDao = ordersDao;
        super.setBaseDao(this.ordersDao);
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
}
