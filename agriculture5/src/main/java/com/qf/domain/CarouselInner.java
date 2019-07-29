package com.qf.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel("轮播图商品")
@Data
@Entity
public class CarouselInner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "items_id")
    private Integer itemsId;//商品编号
    @Column(name = "imgurl")
    private String imgurl;//商品图片
    @Column(name = "title")
    private String title;//商品介绍
    @Column(name = "tejia")
    private String tejia;//优惠
    @Column(name = "num")
    private Integer num;//只有0和1 判别 有无优惠
    @Column(name = "outprice")
    private Double outprice;//原价
    @Column(name = "price")
    private Double price;//现价
    @Column(name = "type")
    private String type;//份/盒/只/g
    @Column(name = "car")
    private String car;//购物车图
}