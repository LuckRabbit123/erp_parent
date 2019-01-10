package cn.itcast.dao.impl;

import cn.itcast.dao.IEmpDao;
import cn.itcast.erp.entity.Emp;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class EmpDao extends BaseDao<Emp> implements IEmpDao {

    public DetachedCriteria getDetachedCriteria(Emp emp1, Emp emp2, Object param){
        DetachedCriteria dc = DetachedCriteria.forClass(Emp.class);
        if (emp1 != null) {
            if (null != emp1.getUsername() && emp1.getUsername().trim().length() > 0) {
                dc.add(Restrictions.like("username", emp1.getUsername(), MatchMode.ANYWHERE));
            }
            if (null != emp1.getPwd() && emp1.getPwd().trim().length() > 0) {
                dc.add(Restrictions.like("pwd", emp1.getPwd(), MatchMode.ANYWHERE));
            }
            if (null != emp1.getName() && emp1.getName().trim().length() > 0) {
                dc.add(Restrictions.like("name", emp1.getName(), MatchMode.ANYWHERE));
            }
            if (null != emp1.getEmail() && emp1.getEmail().trim().length() > 0) {
                dc.add(Restrictions.like("email", emp1.getEmail(), MatchMode.ANYWHERE));
            }
            if (null != emp1.getTele() && emp1.getTele().trim().length() > 0) {
                dc.add(Restrictions.like("tele", emp1.getTele(), MatchMode.ANYWHERE));
            }
            if (null != emp1.getAddress() && emp1.getAddress().trim().length() > 0) {
                dc.add(Restrictions.like("address", emp1.getAddress(), MatchMode.ANYWHERE));
            }
           //TODO:此处未添加性别查询的相应条件
            //根据部门查询
            if (null != emp1.getDep() && null != emp1.getDep().getUuid()) {
                dc.add(Restrictions.eq("dep", emp1.getDep()));
            }
            //出生年月日查询 起始日期
            if (null != emp1.getBirthday()) {
                dc.add(Restrictions.ge("birthday", emp1.getBirthday()));
            }

        }
        return dc;
    }
}
