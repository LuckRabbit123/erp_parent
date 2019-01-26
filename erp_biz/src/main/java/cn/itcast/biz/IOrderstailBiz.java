package cn.itcast.biz;

import cn.itcast.erp.entity.Orderdetail;

public interface IOrderstailBiz extends IBaseBiz<Orderdetail> {
    void doInStore(Long uuid,Long storeuuid, Long empuuid);
    void dooutStore(Long uuid,Long storeuuid,Long emouuid);
}
