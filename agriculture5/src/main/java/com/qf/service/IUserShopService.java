package com.qf.service;

import com.qf.domain.UserShop;

import java.util.List;

public interface IUserShopService {
    int saveUserShop(UserShop userShop);
    List<UserShop> findByUserId(Integer userId);

}
