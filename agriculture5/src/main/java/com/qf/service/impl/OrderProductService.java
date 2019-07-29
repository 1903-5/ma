package com.qf.service.impl;

import com.qf.dao.OrderProductDao;
import com.qf.domain.OrderProduct;
import com.qf.service.IOrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class OrderProductService implements IOrderProductService {

    @Autowired
    private OrderProductDao orderProductDao;

    @Override
    public boolean saveAll(List<OrderProduct> orderProductList) {
        return (orderProductDao.saveAll(orderProductList)!=0)?true:false;
    }

    @Override
    public List<OrderProduct> findOrderProductByOId(String oId) {
        return orderProductDao.findOrderProductByOId(oId);
    }

    @Override
    public boolean deleteOrderProduct(String orderId) {
        return (orderProductDao.deleteOrderProduct(orderId)> 0)?true:false;
    }
}
