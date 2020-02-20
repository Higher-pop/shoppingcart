package com.dao;

import com.entity.ProductEntity;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author SherWin
 * @date 2019/12/2 11:40
 */
public interface ProductDao {
    void insert (ProductEntity productEntity);
    void deleteById(@Param("pid") int pid);
    void update(ProductEntity productEntity);
    List<ProductEntity> getAll();
    ProductEntity getById(@Param("pid") int pid);
}
