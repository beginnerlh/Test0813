package com.lh;

import com.lh.mapper.OrdersMapper;
import com.lh.po.Orders;
import com.lh.po.OrdersEx;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MyBatisTest2 {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void testInitialtive(){
        String file = "sqlMapperConfig.xml";
        InputStream is = null;
        try{
            is = Resources.getResourceAsStream(file);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testQueryOrderToUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

        try {
            List<OrdersEx> ordersExList = ordersMapper.queryOrderToUser();
            System.out.println(ordersExList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryOrderByUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

        try {
            List<Orders> ordersExList = ordersMapper.queryOrderByUser();
            System.out.println(ordersExList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testQueryOrderToOrderDetail(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
            List<Orders> ordersExList = ordersMapper.queryOrderToOrderDetail();
            System.out.println(ordersExList);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testQueryOrderToItems(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
            List<Orders> ordersList = ordersMapper.queryOrderToItems();
            System.out.println(ordersList);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
