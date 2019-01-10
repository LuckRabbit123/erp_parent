package cn.itcast.erp.action;

import cn.itcast.biz.IGoodsTypeBiz;
import cn.itcast.erp.entity.Goodstype;

public class GoodstypeAction extends BaseAction<Goodstype> {
    private IGoodsTypeBiz goodstypeBiz;

    public void setGoodstypeBiz(IGoodsTypeBiz goodstypeBiz) {
        this.goodstypeBiz = goodstypeBiz;
        super.setBaseBiz(this.goodstypeBiz);
    }
}
