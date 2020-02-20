package com.vo;


import com.entity.ProductEntity;

import java.math.BigDecimal;


public class CartItemVO {
	

	private ProductEntity productEntity;
	

	private Integer qty;
	
	public ProductEntity getProductEntity() {
		return productEntity;
	}
	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
	
	public CartItemVO(ProductEntity productEntity) {
		this(productEntity, 1);

	}

	public CartItemVO(ProductEntity productEntity, Integer qty) {
		this.productEntity = productEntity;
		this.qty = qty;
	}

	
	public BigDecimal getSubTotal() {	
		//multiply 乘
		return this.productEntity.getUnitprice().multiply(new BigDecimal(qty));
	}
	
	
	

	
}
