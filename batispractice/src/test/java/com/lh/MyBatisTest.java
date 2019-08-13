package com.lh;

import com.lh.bz.UserBz;
import com.lh.mapper.UserMapper;
import com.lh.po.UserEx;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void testInitialtive(){
        String file = "sqlMapperConfig.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(file);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void testQueryUserByZH(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try{
            UserEx userEx = new UserEx();
            userEx.setSex("2");
            userEx.setUsername("vin");
            UserBz userBz = new UserBz();
            userBz.setUserEx(userEx);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<UserEx> userExList = userMapper.queryUserByZH(null);
            System.out.println(userExList);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
