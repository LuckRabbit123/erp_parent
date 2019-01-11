package cn.itcast.biz.impl;

import cn.itcast.biz.ISupplierBiz;
import cn.itcast.dao.ISupplierDao;
import cn.itcast.dao.impl.BaseDao;
import cn.itcast.erp.entity.Supplier;

public class SupplierBiz extends BaseBiz<Supplier> implements ISupplierBiz {
    private ISupplierDao supplierDao;

    public void setSupplierDao(ISupplierDao supplierDao) {
        this.supplierDao = supplierDao;
        super.setBaseDao(this.supplierDao);
    }
}
