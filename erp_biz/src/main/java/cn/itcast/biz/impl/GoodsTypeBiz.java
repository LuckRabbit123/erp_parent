package cn.itcast.biz.impl;

import cn.itcast.biz.IGoodsTypeBiz;
import cn.itcast.dao.IGoodsTypeDao;
import cn.itcast.erp.entity.Goodstype;

public class GoodsTypeBiz extends BaseBiz<Goodstype> implements IGoodsTypeBiz {
    private IGoodsTypeDao goodsTypeDao;

    public void setGoodsTypeDao(IGoodsTypeDao goodsTypeDao) {
        this.goodsTypeDao = goodsTypeDao;
        super.setBaseDao(this.goodsTypeDao);
    }
}
