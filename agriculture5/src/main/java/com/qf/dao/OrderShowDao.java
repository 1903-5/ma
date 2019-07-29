package com.qf.dao;

import com.qf.domain.OrderShow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderShowDao {

    List<OrderShow> showAllOrderByuserId(Integer userId);
}
