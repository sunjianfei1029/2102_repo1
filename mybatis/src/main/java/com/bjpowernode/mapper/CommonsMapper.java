package com.bjpowernode.mapper;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Map;

public interface CommonsMapper {
    // 根据id查询某条记录，封装成map集合
    Map getById(@Param("tableName") String tableName, @Param("id") Serializable id);

    int insert(@Param("tableName") String tableName, @Param("data") Map data);
    int update(@Param("tableName") String tableName, @Param("data") Map data);
    int delete(@Param("tableName") String tableName, @Param("ids") Serializable[] ids);
}
