package cn.itcast.erp.action;

import cn.itcast.biz.impl.EmpBiz;
import cn.itcast.erp.entity.Emp;

public class EmpAction extends BaseAction<Emp> {
    private EmpBiz empBiz;

    public void setEmpBiz(EmpBiz empBiz) {
        this.empBiz = empBiz;
        super.setBaseBiz(this.empBiz);
    }
}
