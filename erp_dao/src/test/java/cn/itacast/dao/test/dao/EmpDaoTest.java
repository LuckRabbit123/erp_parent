package cn.itacast.dao.test.dao;

import cn.itcast.dao.IEmpDao;
import cn.itcast.dao.impl.EmpDao;
import cn.itcast.erp.entity.Dep;
import cn.itcast.erp.entity.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpDaoTest {
    @Test
    public void testDesp() {
        Object param=null;
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:applicationContext_*.xml");
        IEmpDao empDao = (EmpDao) ac.getBean("empDao");
        Emp emp1 = new Emp();
        Emp emp2 = new Emp();
        Object object = new Object();
        System.out.println(empDao.getList(emp1,emp2,param));
    }
}
