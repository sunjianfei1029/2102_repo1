package com.bjpowernode.test.type;

import com.bjpowernode.mapper.CommonsMapper;
import com.bjpowernode.mapper.ProductMapper;
import com.bjpowernode.mapper.TypeMapper;
import com.bjpowernode.domain.Product;
import com.bjpowernode.domain.Type;
import com.bjpowernode.utils.MyBatisUtils;
import com.bjpowernode.utils.ProxyUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class Tester {
    @Test
    public void test01() {
        try (SqlSession sqlSession = MyBatisUtils.openSession()) {
            // MyBatis根据接口创建实现类（底层实现技术：动态代理）
            TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
            Type type = typeMapper.get(1);
            System.out.println(type);
        }
    }

    @Test
    public void test02() {
        TypeMapper typeMapper = ProxyUtils.getMapper(TypeMapper.class);
        Type type = typeMapper.get(1);
        System.out.println(type);
    }

    @Test
    public void test03() {
        try (SqlSession sqlSession = MyBatisUtils.openSession()) {
            // MyBatis根据接口创建实现类（底层实现技术：动态代理）
            TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
            List types = typeMapper.getAll();
            System.out.println(types);
        }
    }

    @Test
    public void test04() {
        try (SqlSession sqlSession = MyBatisUtils.openSession()) {
            // MyBatis根据接口创建实现类（底层实现技术：动态代理）
            TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
            List types = typeMapper.getAll2("1", "手机数码");
            System.out.println(types);
        }
    }

    @Test
    public void test05() {
        try (SqlSession sqlSession = MyBatisUtils.openSession()) {
            // MyBatis根据接口创建实现类（底层实现技术：动态代理）
            TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
            Type type = new Type();
            type.setName("手机数码");
            List types = typeMapper.getAll3("1", type);
            System.out.println(types);
        }
    }

    @Test
    public void test06() {
        try (SqlSession sqlSession = MyBatisUtils.openSession()) {
            // MyBatis根据接口创建实现类（底层实现技术：动态代理）
            TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
            String name = "手";
            List types = typeMapper.getAll4(name);
            System.out.println(types);
        }
    }

    @Test
    public void test07() {
        try (SqlSession sqlSession = MyBatisUtils.openSession()) {
            // MyBatis根据接口创建实现类（底层实现技术：动态代理）
            CommonsMapper commonsMapper = sqlSession.getMapper(CommonsMapper.class);
            Map map = commonsMapper.getById("product", 40);
            System.out.println(map);
        }
    }

    @Test
    public void test08() {
        try (SqlSession sqlSession = MyBatisUtils.openSession()) {
            // MyBatis根据接口创建实现类（底层实现技术：动态代理）
            TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
            Type type = new Type();
            type.setName("手机数码");
            typeMapper.insert(type);
            System.out.println(type);
            sqlSession.commit();
        }
    }

    @Test
    public void test09() {
        try (SqlSession sqlSession = MyBatisUtils.openSession()) {
            // MyBatis根据接口创建实现类（底层实现技术：动态代理）
            TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
            Type type = typeMapper.get(2);
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            List<Product> products = productMapper.getByTid(2);
            type.setProducts(products);

            Type type1 = typeMapper.getWithProducts(2);
            System.out.println(type);
            System.out.println(type1);
        }
    }

    @Test
    public void test10() {
        try (SqlSession sqlSession = MyBatisUtils.openSession()) {
            // MyBatis根据接口创建实现类（底层实现技术：动态代理）
            TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
            Type type = typeMapper.getWithProductsForNesting(2);
            System.out.println(type);
        }
    }

    @Test
    public void test11() {
        try (SqlSession sqlSession = MyBatisUtils.openSession()) {
            // MyBatis根据接口创建实现类（底层实现技术：动态代理）
            TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
            Type type = typeMapper.get(2);
            Type type2 = typeMapper.get(2);
            System.out.println(type == type2);
        }
    }

}
