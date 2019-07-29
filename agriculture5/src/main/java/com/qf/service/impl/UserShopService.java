package com.qf.service.impl;

import com.qf.dao.UserShopDao;
import com.qf.domain.UserShop;
import com.qf.service.IUserShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserShopService implements IUserShopService {
    @Autowired(required = false)
    private UserShopDao userShopDao;

    @Override
    public int saveUserShop(UserShop userShop) {
        return userShopDao.saveUserShop(userShop);
    }

    @Override
    public List<UserShop> findByUserId(Integer userId) {
        return userShopDao.findByUserId(userId);
    }
}
