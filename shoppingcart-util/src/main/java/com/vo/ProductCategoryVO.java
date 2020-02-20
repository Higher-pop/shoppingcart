package com.vo;



import com.entity.CategoryEntity;
import com.entity.ProductEntity;
import com.page.PageInfoes;

import java.util.List;

/**
 */
public class ProductCategoryVO {
    private List<ProductEntity> products;
    private List<CategoryEntity> categories;
    private PageInfoes pageInfoes;
    private  Integer currentCid;

    public ProductCategoryVO() {
    }

    public ProductCategoryVO(List<ProductEntity> products, 
    		List<CategoryEntity> categories, PageInfoes pageInfoes) {
        this.products = products;
        this.categories = categories;
        this.pageInfoes = pageInfoes;
    }

    public ProductCategoryVO(List<ProductEntity> products, 
    		List<CategoryEntity> categories, 
    		PageInfoes pageInfoes, Integer currentCid) {
        this.products = products;
        this.categories = categories;
        this.pageInfoes = pageInfoes;
        this.currentCid = currentCid;
    }

    public Integer getCurrentCid() {
        return currentCid;
    }

    public void setCurrentCid(Integer currentCid) {
        this.currentCid = currentCid;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }

    public PageInfoes getPageInfoes() {
        return pageInfoes;
    }

    public void setPageInfoes(PageInfoes pageInfoes) {
        this.pageInfoes = pageInfoes;
    }

    @Override
    public String toString() {
        return "ProductCategoryVO{" +
                "products=" + products +
                ", categories=" + categories +
                ", pageInfoes=" + pageInfoes +
                ", currentCid=" + currentCid +
                '}';
    }
}
