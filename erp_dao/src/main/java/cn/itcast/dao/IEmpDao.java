package cn.itcast.dao;

import cn.itcast.erp.entity.Emp;


public interface IEmpDao extends IBaseDao<Emp> {
    /**
     *  验证用户登录
     * @param username
     * @param pwd
     * @return
     */
    Emp findByUsernameAndPwd(String username, String pwd);

    void updatePwd(Long uuid, String newPwd);
}
