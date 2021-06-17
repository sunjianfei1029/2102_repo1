package com.bjpowernode.test.commons;

import com.bjpowernode.mapper.CommonsMapper;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Tester {

    @Test
    public void test01() {
        Map data = new HashMap(){{
            put("name", "美女");
            put("price", "9999");
        }};

        SqlSession sqlSession = MyBatisUtils.openSession();
        CommonsMapper mapper = sqlSession.getMapper(CommonsMapper.class);
        mapper.insert("product", data);

        sqlSession.commit();
        MyBatisUtils.release();

    }

    @Test
    public void test02() {
        Map data = new HashMap(){{
            put("id", "47");
            put("name", "野兽");
            put("price", "999");
        }};

        SqlSession sqlSession = MyBatisUtils.openSession();
        CommonsMapper mapper = sqlSession.getMapper(CommonsMapper.class);
        mapper.update("product", data);

        sqlSession.commit();
        MyBatisUtils.release();

    }

    @Test
    public void test03() {


        SqlSession sqlSession = MyBatisUtils.openSession();
        CommonsMapper mapper = sqlSession.getMapper(CommonsMapper.class);
        mapper.delete("product", new String[]{"37","47"});

        sqlSession.commit();
        MyBatisUtils.release();

    }
}
