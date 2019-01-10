package cn.itcast.erp.action;

import cn.itcast.biz.IGoodsBiz;
import cn.itcast.erp.entity.Goods;

public class GoodsAction extends BaseAction<Goods>{
    private IGoodsBiz goodsBiz;

    public void setGoodsBiz(IGoodsBiz goodsBiz) {
        this.goodsBiz = goodsBiz;
        super.setBaseBiz(this.goodsBiz);
    }
}
