package cn.itcast.biz.impl;

import cn.itcast.biz.IBaseBiz;
import cn.itcast.dao.IBaseDao;

import java.util.List;

/**
 * 通用业务逻辑实现类
 * @author Administrator
 *
 * @param <T>
 */
public class BaseBiz<T> implements IBaseBiz<T> {

    /** 数据访问注入*/
    private IBaseDao<T> baseDao;

    public void setBaseDao(IBaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }

    /**
     * 条件查询
     * @param t1
     * @return
     */
    public List<T> getList(T t1,T t2,Object param){
        return baseDao.getList(t1,t2,param);
    }

    /**
     * 条件查询
     * @param t1
     * @return
     */
    public List<T> getListByPage(T t1,T t2,Object param,int firstResult, int maxResults){
        return baseDao.getListByPage(t1,t2,param,firstResult, maxResults);
    }


    public long getCount(T t1,T t2,Object param) {
        return baseDao.getCount(t1,t2,param);
    }


    public void add(T t) {
        baseDao.add(t);
    }

    /**
     * 删除
     */
    public void delete(Long uuid){
        baseDao.delete(uuid);
    }

    /**
     * 通过编号查询对象
     * @param uuid
     * @return
     */
    public T get(Long uuid){
        return baseDao.get(uuid);
    }

    /**
     * 通过字符串编号查询对象
     * @param uuid
     * @return
     */
    public T get(String uuid){
        return baseDao.get(uuid);
    }

    /**
     * 更新
     */
    public void update(T t){
        baseDao.update(t);
    }

}
