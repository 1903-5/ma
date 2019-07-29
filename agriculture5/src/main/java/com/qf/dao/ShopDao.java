package com.qf.dao;

import com.qf.domain.ProductShop;
import com.qf.domain.Shop;
import com.qf.domain.UserShop;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopDao {
    int saveShop(Shop shop);
    List<Shop> loadByUserIdShowShop(Integer userId);
    int deleteShop(Integer shopId);
    int deleteShopUser(Integer shopId);
    int updateShop(Shop shop);
    Integer getMaxShopId();
    Shop findLikeShop(String productName);
    List<Shop> loadByShopIdSshowShop(List<Integer> list);
    Shop loadByProductIdShowShop(Integer productId);

}
