package com.qf.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel("种类对象")
@Data
@Entity
public class Sort implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sort_id")
    private Integer sortId; //种类编号
    @Column(name = "sort_name")
    private String sortName; //种类名称
}
