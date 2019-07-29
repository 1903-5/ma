package com.qf.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ApiModel("商品对象")
@Data
@Entity
public class ProductPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int proid;
    private  int picid;
}
