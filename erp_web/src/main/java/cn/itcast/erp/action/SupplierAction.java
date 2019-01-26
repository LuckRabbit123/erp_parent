package cn.itcast.erp.action;

import cn.itcast.biz.ISupplierBiz;
import cn.itcast.erp.entity.Supplier;

public class SupplierAction extends BaseAction<Supplier> {
    private ISupplierBiz supplierBiz;

    public void setSupplierBiz(ISupplierBiz supplierBiz) {
        this.supplierBiz = supplierBiz;
        super.setBaseBiz(this.supplierBiz);
    }
}
