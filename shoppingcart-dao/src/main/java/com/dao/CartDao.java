package com.dao;

import com.entity.CartEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author SherWin
 * @date 2019/12/2 11:40
 */
public interface CartDao {

    List<CartEntity> getCartByName(@Param("username") String username);
}
