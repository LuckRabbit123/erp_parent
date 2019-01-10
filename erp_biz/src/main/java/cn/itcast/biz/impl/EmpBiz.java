package cn.itcast.biz.impl;

import cn.itcast.biz.IEmpBiz;
import cn.itcast.dao.IEmpDao;
import cn.itcast.erp.entity.Emp;

public class EmpBiz extends BaseBiz<Emp> implements IEmpBiz {
    private IEmpDao empDao ;

    public void setEmpDao(IEmpDao empDao) {
        this.empDao = empDao;
        super.setBaseDao(this.empDao);
    }

    public Emp findUsernameAndPwd(String username, String pwd) {

        return empDao.findUsernameAndPwd(username,pwd);
    }
}
