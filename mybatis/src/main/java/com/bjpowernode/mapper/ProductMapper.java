package com.bjpowernode.mapper;

import com.bjpowernode.domain.Product;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface ProductMapper {
    Product get(Serializable id);
    // 连接查询：一条SQL出结果
    Product getWithType(Serializable id);
    // 分步查询：多条SQL出结果（效率高）
    Product getWithTypeForNesting(Serializable id);

    List getByCond(Product product);
    int delete(Serializable id);
    int update(Product product);
    int insert(Product product);
    int deleteBatch(@Param("ids") Serializable[] ids);

    List<Product> getByTid(int i);
}
