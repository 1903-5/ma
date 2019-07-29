package com.qf.domain;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@ApiModel("全部子分类对象")
@Data
@Entity
public class Carousel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carouselId; //轮播图id
    private String carouseUrl; //轮播图地址
}
