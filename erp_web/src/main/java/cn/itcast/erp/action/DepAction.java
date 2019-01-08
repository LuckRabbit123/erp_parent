package cn.itcast.erp.action;


import cn.itcast.biz.IDepBiz;
import cn.itcast.erp.entity.Dep;

public class DepAction extends BaseAction<Dep> {

    private IDepBiz depBiz;

    public void setDepBiz(IDepBiz depBiz) {
        this.depBiz = depBiz;
        super.setBaseBiz(this.depBiz);
    }

}
