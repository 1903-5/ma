package com.qf.dao;

import com.qf.domain.AgricultureUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    int updateUserMoney(AgricultureUser user);

    int updatePassword(AgricultureUser user);
    int updatPayPassword(AgricultureUser user);
    int updateMoney(AgricultureUser user);
    public AgricultureUser findUserName(String userName);

}
