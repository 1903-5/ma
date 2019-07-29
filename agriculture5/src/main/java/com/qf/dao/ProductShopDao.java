package com.qf.dao;

import com.qf.domain.ProductShop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductShopDao {
    int saveProductShop(ProductShop productShop);
    int deleteShopProduct(Integer shopId);
    List<ProductShop> loadByShopIdShowProductId(List<Integer> list);
    ProductShop loadShowShopIdByProductId(Integer productId);
}
