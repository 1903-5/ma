package com.qf.dao;

import com.qf.domain.UserShop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserShopDao  {
    int saveUserShop(UserShop userShop);
    List<UserShop> findByUserId(Integer userId);

}
