package cn.itcast.biz.impl;

import cn.itcast.biz.IOrdersBiz;
import cn.itcast.dao.IOrdersDao;
import cn.itcast.erp.entity.Orders;

public class OrdersBiz extends BaseBiz<Orders> implements IOrdersBiz {
    private IOrdersDao ordersDao;

    public void setOrdersDao(IOrdersDao ordersDao) {
        this.ordersDao = ordersDao;
        super.setBaseDao(this.ordersDao);
    }
}
