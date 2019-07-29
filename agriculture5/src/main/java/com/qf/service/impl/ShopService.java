package com.qf.service.impl;

import com.qf.dao.ShopDao;
import com.qf.dao.ShopResponsitory;
import com.qf.dao.UserShopDao;
import com.qf.domain.Shop;
import com.qf.domain.UserShop;
import com.qf.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService implements IShopService {
    @Autowired
    private ShopResponsitory shopResponsitory;
    @Autowired(required = false)
    private ShopDao shopDao;



    @Override
    public List<Shop> findAll() {
        return shopResponsitory.findAll();
    }

    @Override
    public int saveShop(Shop shop) {
        return shopDao.saveShop(shop);
    }

    @Override
    public List<Shop> loadByUserIdShowShop(Integer userId) {
        return shopDao.loadByUserIdShowShop(userId);
    }

    @Override
    public int deleteShop(Integer shopId) {
        shopDao.deleteShopUser(shopId);
       return shopDao.deleteShop(shopId);

    }

    @Override
    public int updateShop(Shop shop) {
        return shopDao.updateShop(shop);
    }

    @Override
    public Integer getMaxShopId() {
        return shopDao.getMaxShopId();
    }

    @Override
    public Shop findLikeShop(String productName) {
        return shopDao.findLikeShop(productName);
    }

    @Override
    public List<Shop> loadByShopIdSshowShop(List<Integer> list) {
        return shopDao.loadByShopIdSshowShop(list);
    }

    @Override
    public Shop loadByProductIdShowShop(Integer productId) {
        return shopDao.loadByProductIdShowShop(productId);
    }


}
