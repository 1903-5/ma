package com.qf.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@ApiModel("合区生活")
@Data
@Entity
@Table(name="agriculture_life")
public class Life implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "imgurl")
    private String imgurl;
    @Column(name = "content")
    private String content;
    @Column(name = "Tuijianxiangqing")
    private String Tuijianxiangqing;
    @Column(name = "Tuijianjiaqian")
    private String Tuijianjiaqian;
    @Column(name = "Tuijianid")
    private int Tuijianid;


}
