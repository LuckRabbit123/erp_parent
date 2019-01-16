package cn.itcast.erp.action;


import cn.itcast.biz.IOrderstailBiz;
import cn.itcast.erp.entity.Emp;
import cn.itcast.erp.entity.Orderdetail;
import cn.itcast.exception.ErpException;

public class OrderstailAction extends BaseAction<Orderdetail> {
    private IOrderstailBiz orderstailBiz;

    public void setOrderstailBiz(IOrderstailBiz orderstailBiz) {
        this.orderstailBiz = orderstailBiz;
        super.setBaseBiz(this.orderstailBiz);
    }
    private Long storeuuid;

    public Long getStoreuuid() {
        return storeuuid;
    }

    public void setStoreuuid(Long storeuuid) {
        this.storeuuid = storeuuid;
    }

    /**
     * 入库
     */
    public void doInStore(){
        Emp loginUser = getLoginUser();
        if(null == loginUser){
            //用户没有登陆，session已失效
            ajaxReturn(false, "亲！您还没有登陆");
            return;
        }
        try {
            //调用明细入库业务  仓库 操作员
            orderstailBiz.doInStore(getId(), storeuuid, loginUser.getUuid());
            ajaxReturn(true, "入库成功");
        }catch (ErpException e){
            ajaxReturn(false, e.getMessage());
        } catch (Exception e) {
            ajaxReturn(false, "入库失败");
            e.printStackTrace();
        }
    }
}
