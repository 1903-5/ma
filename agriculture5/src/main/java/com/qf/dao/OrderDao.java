package com.qf.dao;

import com.qf.domain.Order;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface OrderDao {
    int save(Order order);

    List<Order> findOrderByUserId(Integer userId);

    Order findOrderByOrderId(String orderId);

    int updateOrderStateByOrderId(Order order);

    List<Order> findOrderByOrderState(Order order);

    int deleteOrder(String orderId);

}