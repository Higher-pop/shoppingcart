package com.dao;

import com.entity.SUserEntity;

/**
 * @author SherWin
 * @date 2019/12/2 11:41
 */
public interface SUserDao {
    void insert(SUserEntity sUserEntity);
    SUserEntity getByName(String username);
}
