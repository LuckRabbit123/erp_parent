package cn.itcast.biz.impl;

import cn.itcast.biz.IStoredetailBiz;
import cn.itcast.dao.IStoredetailDao;
import cn.itcast.erp.entity.Storedetail;

public class StoredetailBiz extends BaseBiz<Storedetail> implements IStoredetailBiz {
   private IStoredetailDao storedetailDao;

    public void setStoredetailDao(IStoredetailDao storedetailDao) {
        this.storedetailDao = storedetailDao;
    }
}
