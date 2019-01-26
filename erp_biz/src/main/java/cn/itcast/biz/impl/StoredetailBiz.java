package cn.itcast.biz.impl;

import cn.itcast.biz.IStoredetailBiz;
import cn.itcast.dao.IGoodsDao;
import cn.itcast.dao.IStoreDao;
import cn.itcast.dao.IStoredetailDao;
import cn.itcast.erp.entity.Storedetail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoredetailBiz extends BaseBiz<Storedetail> implements IStoredetailBiz {
   private IStoredetailDao storedetailDao;
    private IGoodsDao goodsDao;
    private IStoreDao storeDao;

    public void setStoredetailDao(IStoredetailDao storedetailDao) {
        this.storedetailDao = storedetailDao;
        super.setBaseDao(this.storedetailDao);
    }

    public void setGoodsDao(IGoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public void setStoreDao(IStoreDao storeDao) {
        this.storeDao = storeDao;
    }

    /**
     * 分页查询
     */
    public List<Storedetail> getListByPage(Storedetail t1, Storedetail t2, Object param, int firstResult, int maxResults){
        List<Storedetail> list = super.getListByPage(t1, t2, param, firstResult, maxResults);
        Map<Long, String> goodsNameMap = new HashMap<Long, String>();
        Map<Long, String> storeNameMap = new HashMap<Long, String>();
        for(Storedetail sd : list){
            sd.setGoodsName(getGoodsName(sd.getGoodsuuid(),goodsNameMap));
            sd.setStoreName(getStoreName(sd.getStoreuuid(),storeNameMap));
        }
        return list;
    }

    private String getGoodsName(Long uuid, Map<Long, String> goodsNameMap){
        if(null == uuid){
            return null;
        }
        String goodsName = goodsNameMap.get(uuid);
        if(null == goodsName){
            goodsName = goodsDao.get(uuid).getName();
            goodsNameMap.put(uuid, goodsName);
        }
        return goodsName;
    }
    private String getStoreName(Long uuid, Map<Long, String> storeNameMap){
        if(null == uuid){
            return null;
        }
        String storeName = storeNameMap.get(uuid);
        if(null == storeName){
            storeName = storeDao.get(uuid).getName();
            storeNameMap.put(uuid, storeName);
        }
        return storeName;
    }


}
