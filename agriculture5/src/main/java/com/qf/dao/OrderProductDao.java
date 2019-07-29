package com.qf.dao;

import com.qf.domain.Order;
import com.qf.domain.OrderProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderProductDao {
    int saveAll(List<OrderProduct> orderProductList);

    List<OrderProduct> findOrderProductByOId(String oId);

    int deleteOrderProduct(String orderId);
}
