package com.qf.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;

@ApiModel("订单详情表")
@Data
@Entity
@Table(name = "order_product")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer zId;  //序列号

    @Column(name = "oid")
    private String oId; //订单编号

    @Column(name = "pid")
    private Integer pId; //商品ID

    @Column(name = "number")
    private Integer number; //商品id对应的数量

    @Column(name = "price")
    private BigDecimal price; //商品当时的价格

    @Column(name = "monicker")
    private String monicker; //商品名称

    @Column(name = "photo")
    private String photo; //商品图片

}
