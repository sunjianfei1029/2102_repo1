package com.bjpowernode.mapper;

import com.bjpowernode.domain.Type;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface TypeMapper {
    List getAll();
    List getAll2(@Param("id") String id, @Param("name") String name);
    List getAll3(@Param("id") String id, @Param("type") Type type);
    List getAll4(String name);
    Type get(Serializable id);
    int delete(Serializable id);
    int update(Type type);
    int insert(Type type);
    // 多表连接查询
    Type getWithProducts(Serializable id);
    // 多表嵌套(分步，即多次)查询
    Type getWithProductsForNesting(Serializable id);

}
