package com.qf.service;

import com.qf.domain.OrderProduct;

import java.util.List;

public interface IOrderProductService {

    boolean saveAll(List<OrderProduct> orderProductList);

    List<OrderProduct> findOrderProductByOId(String oId);

    boolean deleteOrderProduct(String orderId);

}
