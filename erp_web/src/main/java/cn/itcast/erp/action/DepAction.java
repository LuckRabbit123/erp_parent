package cn.itcast.erp.action;


import cn.itcast.biz.IDepBiz;
import cn.itcast.erp.entity.Dep;

public class DepAction extends BaseAction<Dep> {

    private IDepBiz depBiz;

    public void setDepBiz(IDepBiz depBiz) {
        System.out.println("此时进入了Dep");
        this.depBiz = depBiz;
        super.setBaseBiz(this.depBiz);
    }

}
