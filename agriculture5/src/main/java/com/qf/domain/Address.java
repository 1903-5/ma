package com.qf.domain;

import lombok.Data;

import javax.persistence.Column;

@Data
public class Address {
    @Column(name = "add_id")
    private  Integer addressId;   //地址主键
    @Column(name = "user_phone")
    private  Integer userPhone;  // 联系方式
    @Column(name = "user_address")
    private  String userAddress;  //地址
    @Column(name = "user_id")
    private  Integer userId;
    @Column(name = "user_name")
    private String userName;
}
