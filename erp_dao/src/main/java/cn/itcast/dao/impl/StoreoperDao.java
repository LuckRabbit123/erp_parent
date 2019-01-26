package cn.itcast.dao.impl;

import cn.itcast.dao.IStoredetailDao;
import cn.itcast.dao.IStoreoperDao;
import cn.itcast.erp.entity.Storeoper;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class StoreoperDao extends BaseDao<Storeoper> implements IStoreoperDao {
    /**
     * 构建查询条件
     * @param dep1
     * @param dep2
     * @param param
     * @return
     */
    public DetachedCriteria getDetachedCriteria(Storeoper storeoper1, Storeoper storeoper2, Object param){
        DetachedCriteria dc=DetachedCriteria.forClass(Storeoper.class);
        if(storeoper1!=null){
            if(null != storeoper1.getType() && storeoper1.getType().trim().length()>0){
                dc.add(Restrictions.like("type", storeoper1.getType(), MatchMode.ANYWHERE));
            }

        }
        return dc;
    }

}
