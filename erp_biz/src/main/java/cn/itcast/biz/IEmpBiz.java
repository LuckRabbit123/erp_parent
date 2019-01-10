package cn.itcast.biz;

import cn.itcast.dao.IBaseDao;
import cn.itcast.erp.entity.Emp;

public interface IEmpBiz extends IBaseBiz<Emp> {
    Emp findUsernameAndPwd(String username,String pwd);
}
