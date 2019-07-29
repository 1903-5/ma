package com.qf.service;

import com.qf.domain.Shop;
import com.qf.domain.UserShop;

import java.util.List;

public interface IShopService {
    List<Shop> findAll();
    int saveShop(Shop shop);
    List<Shop> loadByUserIdShowShop(Integer userId);
    int deleteShop(Integer shopId);
    int updateShop(Shop shop);
    Integer getMaxShopId();
    Shop findLikeShop(String productName);
    List<Shop> loadByShopIdSshowShop(List<Integer> list);
    Shop loadByProductIdShowShop(Integer productId);

}
