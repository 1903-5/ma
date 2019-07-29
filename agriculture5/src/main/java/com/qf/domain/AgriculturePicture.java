package com.qf.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel("图片对象")
@Data
@Entity
public class AgriculturePicture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "picture_id")
    private Integer pictureId;//图片编号
    @Column(name = "picture_url")
    private String pictureUrl;//图片地址
}
