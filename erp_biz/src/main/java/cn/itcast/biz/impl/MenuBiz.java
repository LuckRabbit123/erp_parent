package cn.itcast.biz.impl;

import cn.itcast.biz.IMenuBiz;
import cn.itcast.dao.IMenuDao;
import cn.itcast.erp.entity.Menu;

public class MenuBiz extends BaseBiz<Menu> implements IMenuBiz {
    private IMenuDao menuDao;

    public void setMenuDao(IMenuDao menuDao) {
        this.menuDao = menuDao;
        super.setBaseDao(this.menuDao);
    }
}
