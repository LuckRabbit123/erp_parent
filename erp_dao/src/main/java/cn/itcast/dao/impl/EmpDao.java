package cn.itcast.dao.impl;

import cn.itcast.dao.IEmpDao;
import cn.itcast.erp.entity.Dep;
import cn.itcast.erp.entity.Emp;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class EmpDao extends BaseDao<Emp> implements IEmpDao {

    public DetachedCriteria getDetachedCriteria(Emp emp1, Emp emp2, Object param){
        DetachedCriteria dc=DetachedCriteria.forClass(Dep.class);
        if(emp1!=null){
            if(null != emp1.getName() && emp1.getName().trim().length()>0){
                dc.add(Restrictions.like("name", emp1.getName(), MatchMode.ANYWHERE));
            }
            if(null != emp1.getTele() && emp1.getTele().trim().length()>0){
                dc.add(Restrictions.like("tele", emp1.getTele(), MatchMode.ANYWHERE));
            }

        }
        return dc;
    }
}
