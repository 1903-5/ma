package com.qf.service;

import com.qf.domain.Order;

import java.util.List;

public interface IOrderService {

    boolean save(Order order);

    List<Order> findOrderIdByUserId(Integer userId);

    Order findOrderByOrderId(String orderId);

    boolean updateOrderStateByOrderId(Order order);

    List<Order> findOrderByOrderState(Order order);

    boolean deleteOrder(String orderId);
}
