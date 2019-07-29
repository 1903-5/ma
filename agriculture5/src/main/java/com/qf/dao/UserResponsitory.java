package com.qf.dao;


import com.qf.domain.AgricultureUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserResponsitory extends JpaRepository<AgricultureUser ,Integer> {

    AgricultureUser  findByUserNameAndUserPassword(String userName,String userPassword);

    AgricultureUser  findByUserName(String userName);

    AgricultureUser  findByUserNameAndUserEmail(String userName,String userEmail);

    AgricultureUser findByUserId(Integer userId);
    AgricultureUser findByUserIdAndAndUserPayPassword(Integer userId,String userPayPassword);
    AgricultureUser findByUserIdAndUserPayPassword(Integer userId,String userPayPassword);


}