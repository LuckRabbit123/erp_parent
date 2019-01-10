package cn.itcast.biz.impl;

import cn.itcast.dao.IGoodsDao;
import cn.itcast.erp.entity.Goods;

public class GoodsBiz extends BaseBiz<Goods> implements IGoodsDao {
    private IGoodsDao goodsDao;

    public void setGoodsDao(IGoodsDao goodsDao) {
        this.goodsDao = goodsDao;
        super.setBaseDao(this.goodsDao);
    }
}
