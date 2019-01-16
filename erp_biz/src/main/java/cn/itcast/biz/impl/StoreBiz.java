package cn.itcast.biz.impl;

import cn.itcast.biz.IStoreBiz;
import cn.itcast.dao.IStoreDao;
import cn.itcast.erp.entity.Store;

public class StoreBiz extends BaseBiz<Store> implements IStoreBiz {
    private IStoreDao storeDao;

    public void setStoreDao(IStoreDao storeDao) {
        this.storeDao = storeDao;
        super.setBaseDao(this.storeDao);
    }
}
