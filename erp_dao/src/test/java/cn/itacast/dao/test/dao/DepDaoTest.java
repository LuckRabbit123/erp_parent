package cn.itacast.dao.test.dao;

import cn.itcast.dao.IDepDao;
import oracle.jdbc.driver.OracleDriver;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;

public class DepDaoTest {
    @Test
    public void testDesp(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:applicationContext_*.xml");
        IDepDao depDao = (IDepDao)ac.getBean("depDao");
        System.out.println();
        //ac.getBean("sessionFactory");

//        String firstName = null;
//        String lastName = null;
//        String email = null;
//        Connection connect = null
//        Statement statement = null;
//        ResultSet resultSet = null;
//        try {
//            Driver driver = new OracleDriver();
//            DriverManager.deregisterDriver(driver);
//            connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:XE", "erpuser", "itcast");
//
//
//            String sql = "SELECT * FROM DEP ";
//
//            PreparedStatement pstmt = connect.prepareStatement(sql);
//            ResultSet rset = pstmt.executeQuery();
//            while(rset.next()) {
//                firstName = rset.getString(1);
//                lastName = rset.getString(2);
//                email = rset.getString(3);
//                System.out.println(firstName + " " + lastName + " " +
//                        email);
//            }
//            pstmt.close();
//            rset.close();
//        } catch (SQLException ex){
//            System.err.println("ERROR: " + ex);
//        }

    }

}
