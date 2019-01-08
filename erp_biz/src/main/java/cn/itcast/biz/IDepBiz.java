package cn.itcast.biz;

import cn.itcast.erp.entity.Dep;

import java.util.List;

public interface IDepBiz {
    List<Dep> getList();
    List<Dep> getList(Dep dep1, Dep dep2, Object param,int firstResult,int maxResuts);
    Long getCount(Dep dep1, Dep dep2, Object param);
    void add(Dep dep);
    void delete(Long uuid);
    Dep get(Long uuid);
    void update(Dep dep);
}
