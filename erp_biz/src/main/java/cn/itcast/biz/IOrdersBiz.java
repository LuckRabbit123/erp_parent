package cn.itcast.biz;

import cn.itcast.erp.entity.Orders;

public interface IOrdersBiz extends IBaseBiz<Orders> {
    /**
     * 审核
     * @param uuid 订单编号
     * @param empUuid 审核员
     */
    void doCheck(Long uuid,Long empUuid);
    void doStart(Long uuid,Long empUuid);

}
