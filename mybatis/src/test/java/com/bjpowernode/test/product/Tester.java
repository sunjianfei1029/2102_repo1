package com.bjpowernode.test.product;

import com.bjpowernode.domain.Type;
import com.bjpowernode.mapper.ProductMapper;
import com.bjpowernode.domain.Product;
import com.bjpowernode.mapper.TypeMapper;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Tester {
    @Test
    public void test01() {
        SqlSession sqlSession = MyBatisUtils.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        Product product = new Product();
        product.setName("尔");
        product.setDescription("黑");
        List list = productMapper.getByCond(product);
        System.out.println(list);
        MyBatisUtils.release();
    }

    @Test
    public void test02() {
        SqlSession sqlSession = MyBatisUtils.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        String[] ids = new String[] {"34", "35"};
        productMapper.deleteBatch(ids);
        MyBatisUtils.commit();
        MyBatisUtils.release();
    }

    @Test
    public void test03() {
        SqlSession sqlSession = MyBatisUtils.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        Product product = productMapper.getWithType(40);
        System.out.println(product);

        MyBatisUtils.commit();
        MyBatisUtils.release();
    }

    @Test
    public void test04() {
        SqlSession sqlSession = MyBatisUtils.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        Product product = productMapper.getWithTypeForNesting(40);
        System.out.println(product);
        // 思考（面试题）：延迟加载的底层实现原理：动态代理
        System.out.println(product.getType());
        MyBatisUtils.release();
    }

    @Test
    public void test05() {
        SqlSession sqlSession = MyBatisUtils.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        Product product = productMapper.get(40);
        // 释放资源，将查询的数据保存到磁盘中
        MyBatisUtils.release();

        SqlSession sqlSession2 = MyBatisUtils.openSession();
        ProductMapper productMapper2 = sqlSession2.getMapper(ProductMapper.class);
        Product pro = new Product();
        pro.setName("测试");
        productMapper2.insert(pro);
        sqlSession2.commit();

        Product product2 = productMapper2.get(40);

    }

    /*
        测试二级缓存不适用于连接查询，测试步骤：
        1. 调用连接查询
        2. 释放资源，让二级缓存生效
        3. 修改关联表中的数据
        4. 再次调用连接查询，查询是否是脏数据
     */
    @Test
    public void test06() {
        SqlSession sqlSession = MyBatisUtils.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        Product product = productMapper.getWithType(40);
        // 释放资源，将查询的数据保存到磁盘中
        MyBatisUtils.release();
        System.out.println(product);
        System.out.println(product);
        System.out.println(product);
        System.out.println(product);
        System.out.println(product);


        SqlSession sqlSession2 = MyBatisUtils.openSession();
        TypeMapper typeMapper = sqlSession2.getMapper(TypeMapper.class);
        Type type = new Type();
        type.setId("2");
        type.setName("电脑办公2");
        typeMapper.update(type);
        sqlSession2.commit();

        ProductMapper productMapper2 = sqlSession2.getMapper(ProductMapper.class);
        Product product2 = productMapper2.getWithType(40);
        System.out.println(product2);
        System.out.println(product2);
        System.out.println(product2);
        System.out.println(product2);
        System.out.println(product2);
    }


    @Test
    public void test07() {
        SqlSession sqlSession = MyBatisUtils.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        Product product = productMapper.getWithTypeForNesting(40);
        // 释放资源，将查询的数据保存到磁盘中
        MyBatisUtils.release();
        System.out.println(product);
        System.out.println(product);
        System.out.println(product);
        System.out.println(product);
        System.out.println(product);


        SqlSession sqlSession2 = MyBatisUtils.openSession();
        ProductMapper productMapper2 = sqlSession2.getMapper(ProductMapper.class);
        Product product2 = productMapper2.getWithTypeForNesting(40);
        System.out.println(product2);
        System.out.println(product2);
        System.out.println(product2);
        System.out.println(product2);
        System.out.println(product2);
        System.out.println(product2.getType());
    }
}
