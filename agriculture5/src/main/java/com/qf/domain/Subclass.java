package com.qf.domain;

import lombok.Data;

import javax.persistence.*;

@Data   //自动生成Get Set方法及构造函数
@Entity //实体类
public class Subclass {         //  子类产品
    @Id     //数据库表的主键，且非空
    @GeneratedValue(strategy = GenerationType.IDENTITY) //数据库表的主键是自增长
    @Column(name = "subclass_id")   //数据库表的一个列
    private Integer subclassId;     //  子类产品编号
    @Column(name = "subclass_name")
    private String subclassName;    //  子类产品名称
}
