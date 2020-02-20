package com.service.impl;

import com.dao.CartDao;
import com.entity.CartEntity;
import com.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SherWin
 * @date 2019/12/3 9:33
 */


@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;
    @Override
    public List<CartEntity> getCartByName(String username) {
        return cartDao.getCartByName(username);
    }
}
