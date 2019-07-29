package com.qf.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel("购物车对象")
@Data
@Entity
@Table(name = "shop")
public class Shop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private Integer shopId;//购物车商品编号
    @Column(name = "shop_title")
    private String shopTitle;//购物车商品名称
    @Column(name = "shop_img")
    private String shopImg;//购物车商品图片
    @Column(name = "shop_num")
    private Integer shopNum;//购物车商品数量
    @Column(name = "shop_price")
    private BigDecimal shopPrice;//购物车商品单价
}
