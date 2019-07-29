package com.qf.service;

import com.qf.domain.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressService {



    List<Address> findAddressByuserID(Integer userId);



    int deleteById(Integer id);


    int insertadd(String userPhone,String userAddress,String userName,Integer userId);


    int updateAdd( Integer userPhone, String userAddress, Integer addId);
}