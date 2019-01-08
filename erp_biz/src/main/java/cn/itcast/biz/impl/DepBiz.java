package cn.itcast.biz.impl;

import cn.itcast.biz.IDepBiz;
import cn.itcast.dao.IDepDao;
import cn.itcast.erp.entity.Dep;

import java.util.List;

public class DepBiz implements IDepBiz {
    private IDepDao depDao;

    public void setDepDao(IDepDao depDao) {
        this.depDao = depDao;
    }

    public List<Dep> getList() {
        return depDao.getList();
    }

    public List<Dep> getList(Dep dep1, Dep dep2, Object param,int firstResult,int maxResuts) {
        return depDao.getList(dep1,dep2, param,firstResult,maxResuts);
    }
    public Long getCount(Dep dep1, Dep dep2, Object param){
        return depDao.getCount(dep1,dep2,param);
    }

    public void add(Dep dep) {
       depDao.add(dep);
    }

    public void delete(Long uuid) {
        depDao.delete(uuid);
    }

    public Dep get(Long uuid) {
        return depDao.get(uuid);
    }

    public void update(Dep dep) {
        depDao.update(dep);
    }
}
