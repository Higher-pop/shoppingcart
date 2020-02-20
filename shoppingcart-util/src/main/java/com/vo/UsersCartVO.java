package com.vo;


import com.entity.CartEntity;
import com.entity.SUserEntity;

import java.util.List;

public class UsersCartVO {

	private List<CartEntity> cartEntities;
	private SUserEntity sUserEntity;
	
	public List<CartEntity> getCartEntities() {
		return cartEntities;
	}
	public void setCartEntities(List<CartEntity> cartEntities) {
		this.cartEntities = cartEntities;
	}
	public SUserEntity getsUserEntity() {
		return sUserEntity;
	}
	public void setsUserEntity(SUserEntity sUserEntity) {
		this.sUserEntity = sUserEntity;
	}
	public UsersCartVO() {
		super();
	}
	public UsersCartVO(List<CartEntity> carts, SUserEntity user) {
		super();
		this.cartEntities = carts;
		this.sUserEntity = user;
	}
	@Override
	public String toString() {
		return "UsersCartVO [carts=" + cartEntities + ", user=" + sUserEntity + "]";
	}
	
	
}
