package com.qf.service;

import com.qf.domain.AgricultureUser;

public interface IUserService {

    boolean save(AgricultureUser users);//增加一个用户

    AgricultureUser findByUserNameAndUserPassword(String userName, String userPassword);//校验账户和密码

    boolean findByUserName(String userName);//校验用户名是否存在

    boolean findByUserNameAndUserEmail(String userName, String userEmail);//校正邮箱和用户名一致

    AgricultureUser findByUserId(Integer userId);

    boolean updatePassWord(AgricultureUser user);

    boolean updateUserMoney(AgricultureUser user);
    boolean findByUserIdAndUserPassword(Integer userId,String userPayPassword);
    boolean findByUserIdAndUserPayPassWord(Integer userId,String userPayPassword);

    AgricultureUser findUserName(String userName);


    boolean updatePayPassword(AgricultureUser agricultureUser);

}
