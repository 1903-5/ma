package com.qf.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderShow {

    private String orderId; //订单编号

    private String orderLogistics; //订单物流

    private BigDecimal orderPrice; //订单总价

    private Integer orderState; //订单状态

    private String orderProductMonicker; //订单商品名字

    private String orderProductNumber; //订单商品数量

    private String orderProductPhoto; //订单商品图片

    private BigDecimal orderProductPrice; //订单商品单价

}