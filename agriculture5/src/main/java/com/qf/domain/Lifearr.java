package com.qf.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
@Table(name="Lifearr")
public class Lifearr implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Lifearrid;
    private int lid;
    private String Lifearrimgurl;
    private String Lifearrspan;
    private String Lifearrname;
    private String Lifearryuefen;
    private String Lifearrxing1;
    private String Lifearrxing2;
    private String Lifearrxing3;
    private String Lifearrimgarr1;
    private String Lifearrimgarr2;
    private String Lifearrimgarr3;
    private String Lifearrimgarr4;
    private String Lifearrimgarr5;
    private String Lifearrimgarr6;
    private String dinazannum;
    private String Lifearrcontent;
}
