package com.bjpowernode.test.product;

import com.bjpowernode.domain.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ProductTest {

    @Test
    public void test01() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session  = sqlSessionFactory.openSession();
        Product product = session.selectOne("product.get", 40);
        System.out.println(product);
        session.close();
    }

    @Test
    public void test02() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session  = sqlSessionFactory.openSession();

        session.delete("product.delete", 47);
        session.commit();
        session.close();
    }

    @Test
    public void test03() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session  = sqlSessionFactory.openSession();

        Product product = new Product();
        product.setName("小米M2");
        product.setPrice("999");

        session.insert("product.insert", product);
        session.commit();
        session.close();
    }

    @Test
    public void test04() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session  = sqlSessionFactory.openSession();

        Product product = new Product();
        product.setId("48");
        product.setPrice("1999");

        session.insert("product.update", product);
        session.commit();
        session.close();
    }
}
