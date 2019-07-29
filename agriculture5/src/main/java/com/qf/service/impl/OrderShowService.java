package com.qf.service.impl;

import com.qf.dao.OrderShowDao;
import com.qf.domain.OrderShow;
import com.qf.service.IOrderShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderShowService implements IOrderShowService {

    @Autowired
    private OrderShowDao orderShowDao;

    @Override
    public List<OrderShow> showAllOrderByuserId(Integer userId) {
        return orderShowDao.showAllOrderByuserId(userId);
    }
}
