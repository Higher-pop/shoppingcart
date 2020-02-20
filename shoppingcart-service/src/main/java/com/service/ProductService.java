package com.service;

import com.entity.ProductEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author SherWin
 * @date 2019/12/3 14:57
 */
public interface ProductService {
    void insert (ProductEntity productEntity);
    void deleteById(int pid);
    void update(ProductEntity productEntity);
    List<ProductEntity> getAll();
    ProductEntity getById(int pid);
    List<ProductEntity> getProductsByCondition(Map<String, Object> conditions, int start, int end);
    int getProductsCountByCondition(Map<String, Object> conditions);
    List<ProductEntity> getPagedRecords(int start ,int end);
    int getRecordCount();
}
