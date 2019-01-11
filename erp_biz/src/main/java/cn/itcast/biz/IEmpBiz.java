package cn.itcast.biz;

import cn.itcast.dao.IBaseDao;
import cn.itcast.erp.entity.Emp;

public interface IEmpBiz extends IBaseBiz<Emp> {
    /**
     * 用户登陆
     * @param username
     * @param pwd
     * @return
     */
    Emp findByUsernameAndPwd(String username, String pwd);

    /**
     * 修改密码
     */
    void updatePwd(Long uuid, String oldPwd, String newPwd);
}
