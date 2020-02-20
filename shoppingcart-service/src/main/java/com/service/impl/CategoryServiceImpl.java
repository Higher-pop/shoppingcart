package com.service.impl;

import com.dao.CategoryDao;
import com.entity.CategoryEntity;
import com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SherWin
 * @date 2019/12/3 9:31
 */


@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public void insert(CategoryEntity categoryEntity) {
        categoryDao.insert(categoryEntity);
    }

    @Override
    public void deleteById(Integer cid) {
        categoryDao.deleteById(cid);
    }

    @Override
    public void update(CategoryEntity categoryEntity) {
        categoryDao.update(categoryEntity);
    }

    @Override
    public List<CategoryEntity> getAll() {
        return categoryDao.getAll();
    }
}
