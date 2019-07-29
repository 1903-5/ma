package com.qf.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AgricuUserDao {


    int updatepaypassword(@Param("userPaypassword") String userPaypassword,
                          @Param("userid") Integer userid);
}
