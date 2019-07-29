package com.qf.service;

import com.qf.domain.OrderShow;

import java.util.List;

public interface IOrderShowService {

    List<OrderShow> showAllOrderByuserId(Integer userId);

}
