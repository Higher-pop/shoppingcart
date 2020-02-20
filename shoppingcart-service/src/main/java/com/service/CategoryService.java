package com.service;

import com.entity.CategoryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author SherWin
 * @date 2019/12/3 14:56
 */
public interface CategoryService {
    void insert(CategoryEntity categoryEntity);
    void deleteById(Integer cid);
    void update(CategoryEntity categoryEntity);
    List<CategoryEntity> getAll();
}
