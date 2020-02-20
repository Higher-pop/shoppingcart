package com.service.impl;

import com.dao.SUserDao;
import com.entity.SUserEntity;
import com.service.SUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author SherWin
 * @date 2019/12/3 9:34
 */


@Service
public class SUserServiceImpl implements SUserService {
    @Autowired
    private SUserDao sUserDao;
    @Override
    public void insert(SUserEntity sUserEntity) {
        sUserDao.insert(sUserEntity);
    }

    @Override
    public SUserEntity getByName(String username) {
        return sUserDao.getByName(username);
    }
}
