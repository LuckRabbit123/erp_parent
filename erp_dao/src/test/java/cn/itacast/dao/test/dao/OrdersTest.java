package cn.itacast.dao.test.dao;

import cn.itcast.dao.IOrdersDao;
import cn.itcast.dao.impl.GoodsDao;
import cn.itcast.dao.impl.OrdersDao;
import cn.itcast.erp.entity.Orders;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class OrdersTest {
    @Test
    public void Main() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:applicationContext_*.xml");
        IOrdersDao ordersDao = (OrdersDao) ac.getBean("ordersDao");
        System.out.println(ordersDao);
    }
}
