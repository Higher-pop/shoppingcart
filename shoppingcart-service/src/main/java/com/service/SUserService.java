package com.service;

import com.entity.SUserEntity;

/**
 * @author SherWin
 * @date 2019/12/3 14:57
 */
public interface SUserService {
    void insert(SUserEntity sUserEntity);
    SUserEntity getByName(String username);
}
