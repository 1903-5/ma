package com.qf.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel("全部类目对象")
@Data
@Entity
@Table(name = "categories")
public class Categories implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categories_id")
    private Integer categoriesId; //类目编号
    @Column(name = "categories_name")
    private String categoriesName; //类目名称
    @Column(name = "categories_image")
    private String categoriesImage;//类目图片
}
