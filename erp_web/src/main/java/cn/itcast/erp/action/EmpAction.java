package cn.itcast.erp.action;

import cn.itcast.biz.IEmpBiz;
import cn.itcast.erp.entity.Emp;

public class EmpAction extends BaseAction<Emp> {
    private IEmpBiz empBiz;

    public void setEmpBiz(IEmpBiz empBiz) {
        this.empBiz = empBiz;
        super.setBaseBiz(this.empBiz);
    }
}
