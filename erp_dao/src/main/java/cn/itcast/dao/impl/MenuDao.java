package cn.itcast.dao.impl;

import cn.itcast.dao.IMenuDao;
import cn.itcast.erp.entity.Menu;
import org.hibernate.criterion.DetachedCriteria;

public class MenuDao extends BaseDao<Menu> implements IMenuDao {
    /**
     * 构建查询条件
     * @param dep1
     * @param dep2
     * @param param
     * @return
     */
    public DetachedCriteria getDetachedCriteria(Menu menu1, Menu menu2, Object param){
        DetachedCriteria dc=DetachedCriteria.forClass(Menu.class);
        return dc;
    }
}
