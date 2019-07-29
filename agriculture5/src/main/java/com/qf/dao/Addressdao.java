package com.qf.dao;

import com.qf.domain.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface Addressdao {


    List<Address> findAddressByuserID(@Param("userId") Integer userId);


    int deleteById(Integer id);


    int insertadd(@Param("userPhone") String userPhone,
                  @Param("userAddress") String userAddress,
                  @Param("userName") String userName,
                  @Param("userId") Integer userId);


    int updateAdd(@Param("userPhone") Integer userPhone,
                  @Param("userAddress") String userAddress,
                  @Param("addId") Integer addId);

}