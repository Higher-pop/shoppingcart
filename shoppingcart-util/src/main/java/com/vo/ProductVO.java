package com.vo;


import java.util.List;

import com.entity.ProductEntity;
import com.page.*;
/**
 * 
 */
public class ProductVO {
    private PageInfoes pageInfoes;
    private List<ProductEntity> products;

    public ProductVO() {
    }

    public ProductVO(PageInfoes pageInfoes, List<ProductEntity> products) {
        this.pageInfoes = pageInfoes;
        this.products = products;

    }

    public PageInfoes getPageInfoes() {
        return pageInfoes;
    }

    public void setPageInfoes(PageInfoes pageInfoes) {
        this.pageInfoes = pageInfoes;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProductVO{" +
                "pageNumber=" + pageInfoes +
                ", products=" + products +
                '}';
    }
}
