package cn.itcast.dao.impl;

import cn.itcast.dao.IGoodsTypeDao;
import cn.itcast.erp.entity.Goodstype;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class GoodsTypeDao extends BaseDao<Goodstype> implements IGoodsTypeDao {

    @Override
    public DetachedCriteria getDetachedCriteria(Goodstype goodstype1, Goodstype goodstype2, Object param) {
        DetachedCriteria dc = DetachedCriteria.forClass(Goodstype.class);
        if (goodstype1 != null) {
            if (null != goodstype1.getName() && goodstype1.getName().trim().length() > 0) {
                dc.add(Restrictions.like("name", goodstype1.getName(), MatchMode.ANYWHERE));
            }

        }
        return dc;
    }
}
