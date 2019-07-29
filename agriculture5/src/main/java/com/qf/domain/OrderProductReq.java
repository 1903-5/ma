package com.qf.domain;

import lombok.Data;

import java.util.List;

@Data
public class OrderProductReq {

    private Integer userId;
    private List<OrderProductList> orderProductListList;
}
