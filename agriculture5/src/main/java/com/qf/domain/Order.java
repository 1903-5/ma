package com.qf.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

//package com.qf.domain;
//
//import io.swagger.annotations.ApiModel;
//import lombok.Data;
//import org.springframework.data.annotation.Id;
//
//import javax.persistence.*;
//import java.math.BigDecimal;

@ApiModel("订单")
@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private String orderId; //订单编号

    @Column(name = "u_id")
    private Integer uId; //用户Id

    @Column(name = "order_logistics")
    private String orderLogistics; //物流信息

    @Column(name = "order_state")
    private Integer orderState; //订单状态

    @Column(name = "order_price")
    private BigDecimal orderPrice; //订单总价
}
