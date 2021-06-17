package com.bjpowernode.utils;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtils {
    public static <T> T getMapper(Class<T> clazz) {
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 接口的全限定名，就是映射文件的命名空间
                String namespace = clazz.getName();
                // 获取方法名: 映射文件中标签id
                String id = method.getName();

                // 最终要执行的方法是：namespace + "." + id
                String str = namespace + "." + id;
                SqlSession session = MyBatisUtils.openSession();
                return session.selectOne(str, args[0]);
            }
        });
    }
}
