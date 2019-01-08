package cn.itcast.biz.impl;

import cn.itcast.biz.IDepBiz;
import cn.itcast.dao.IDepDao;
import cn.itcast.erp.entity.Dep;

import java.util.List;

public class DepBiz extends BaseBiz<Dep> implements IDepBiz {
    private IDepDao depDao;

    public void setDepDao(IDepDao depDao) {
        this.depDao = depDao;
        super.setBaseDao(this.depDao);
    }

}
