package cn.itcast.erp.action;

import cn.itcast.biz.IStoredetailBiz;
import cn.itcast.erp.entity.Storedetail;

public class StoredetailAction extends BaseAction<Storedetail> {
    private IStoredetailBiz storedetailBiz;

    public void setStoredetailBiz(IStoredetailBiz storedetailBiz) {
        this.storedetailBiz = storedetailBiz;
        super.setBaseBiz(this.storedetailBiz);
    }
}
