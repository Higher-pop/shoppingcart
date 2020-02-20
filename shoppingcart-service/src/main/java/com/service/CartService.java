package com.service;

import com.entity.CartEntity;
import java.util.List;

/**
 * @author SherWin
 * @date 2019/12/3 11:51
 */
public interface CartService {
    List<CartEntity> getCartByName( String username);
}
