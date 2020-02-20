package com.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CartVO {
    private Map<Integer, CartItemVO> carts = new HashMap();
    /**
     * 	添加购物项
     * @param item
     */
    public void addCartItem(CartItemVO item) {
        CartItemVO itemInCart = carts.get(item.getProductEntity().getPid());
        if(itemInCart!=null) {
        	itemInCart.setQty(itemInCart.getQty() + item.getQty());
        }else {
            carts.put(item.getProductEntity().getPid(), item);//键和值
        }
    }
    /**
     * 	得到购物项
     * @return
     */
    public List<CartItemVO> getItems(){
    	//将hashmap的值数组放到arraylist集合中
        return new ArrayList<CartItemVO>(carts.values());

    }
    /**
     *	 得到类型数量
     */
    public int getCategoryCount(){
        return carts.size();
    }
    /**
     *	得到总价
     */
    public int getItemCount(){

        int total = 0;
        for (CartItemVO item : carts.values()) {
            total+= item.getQty();
        }
        return  total;
    }
    /**
     * 	删除购物项
     * @param id
     * @param qty
     */
    public void removeItems(Integer id, Integer qty) {
        CartItemVO itemInCart = carts.get(id);
        if(itemInCart==null) {return ;}

        //long newValue = itemInCart.getQty() -qty;
        Integer newValue = qty;
	
		if(newValue<=0) { carts.remove(id); }else { itemInCart.setQty(newValue); }
		 
    }
    /**
     * 	移除某商品
     * @param id
     */
    public void removeItems(Integer id) {
        CartItemVO itemInCart = carts.get(id);
        if(itemInCart==null) {return ;}

        carts.remove(id);
    }
    /**
     * 	得到所有商品的总价格
     */
    public BigDecimal getTotal(){
        BigDecimal total = new BigDecimal(0);
        for (CartItemVO item :carts.values()) {
            total = total.add(item.getSubTotal());
        }
        return  total;
    }
}
