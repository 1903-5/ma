package com.qf.service;

import com.qf.domain.ProductShop;

import java.util.List;

public interface IProductShopService {
    int saveProductShop(ProductShop productShop);
    int deleteShopProduct(Integer shopId);
    List<ProductShop> loadByShopIdShowProductId(List<Integer> list);
    ProductShop loadShowShopIdByProductId(Integer productId);


}
