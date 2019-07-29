package com.qf.service.impl;

import com.qf.dao.ProductShopDao;
import com.qf.domain.ProductShop;
import com.qf.service.IProductShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductShopService implements IProductShopService {
    @Autowired
    private ProductShopDao productShopDao;
    @Override
    public int saveProductShop(ProductShop productShop) {
        return productShopDao.saveProductShop(productShop);
    }

    @Override
    public int deleteShopProduct(Integer shopId) {
        return productShopDao.deleteShopProduct(shopId);
    }

    @Override
    public List<ProductShop> loadByShopIdShowProductId(List<Integer> list) {
        return productShopDao.loadByShopIdShowProductId(list);
    }

    @Override
    public ProductShop loadShowShopIdByProductId(Integer productId) {
        return productShopDao.loadShowShopIdByProductId(productId);
    }
}
