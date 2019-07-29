package com.qf.service.impl;

import com.qf.dao.OrderDao;
import com.qf.domain.Order;
import com.qf.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public boolean save(Order order) {

        return (orderDao.save(order)==1)?true:false;
    }

    @Override
    public List<Order> findOrderIdByUserId(Integer userId) {
        return orderDao.findOrderByUserId(userId);
    }

    @Override
    public Order findOrderByOrderId(String orderId) {
        return orderDao.findOrderByOrderId(orderId);
    }

    @Override
    public boolean updateOrderStateByOrderId(Order order) {
        return (orderDao.updateOrderStateByOrderId(order)==1)?true:false;
    }

    @Override
    public List<Order> findOrderByOrderState(Order order) {
        return orderDao.findOrderByOrderState(order);
    }

    @Override
    public boolean deleteOrder(String orderId) {
        return (orderDao.deleteOrder(orderId)==1)?true:false;
    }

}