package cn.itacast.dao.test.dao;

import cn.itcast.dao.IEmpDao;
import cn.itcast.dao.impl.EmpDao;
import cn.itcast.dao.impl.GoodsDao;
import cn.itcast.erp.entity.Goods;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GoodsTest {
    @Test
    public void Test(){
        Object param=null;
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:applicationContext_*.xml");
        GoodsDao goodsDao = (GoodsDao) ac.getBean("goodsDao");
        System.out.println(goodsDao);

    }
}
