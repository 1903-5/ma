package com.qf.service.impl;

import com.qf.dao.AgricuUserDao;
import com.qf.dao.UserDao;
import com.qf.dao.UserResponsitory;
import com.qf.domain.AgricultureUser;
import com.qf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserResponsitory  userResponsitory;
    @Autowired
    private UserDao userDao;
    @Autowired
    private AgricuUserDao agricuUserDao;

    @Override
    public boolean save(AgricultureUser  users) {
        return (userResponsitory.save(users)!=null)?true:false;
    }

    @Override
    public AgricultureUser findByUserNameAndUserPassword(String userName, String userPassword) {
        return userResponsitory.findByUserNameAndUserPassword(userName,userPassword);
    }

    @Override
    public boolean findByUserName(String userName) {
        return (userResponsitory.findByUserName(userName)!=null)?true:false;
    }

    @Override
    public boolean findByUserNameAndUserEmail(String userName, String userEmail) {
        return (userResponsitory.findByUserNameAndUserEmail(userName,userEmail)!=null)?true:false;
    }



    @Override
    public AgricultureUser findByUserId(Integer userId) {
        return userResponsitory.findByUserId(userId);
    }

    @Override
    public boolean updateUserMoney(AgricultureUser user) {
        return (userDao.updateUserMoney(user)==1)?true:false;
    }



    public int updatepaypassword(String userPaypassword, Integer userid) {
        return agricuUserDao.updatepaypassword(userPaypassword,userid);
    }
    @Override
    public boolean updatePassWord(AgricultureUser user) {
        return (userDao.updatePassword(user)==1)?true:false;
    }


    @Override
    public boolean findByUserIdAndUserPassword(Integer userId, String userPayPassword) {
        return (userResponsitory.findByUserIdAndAndUserPayPassword(userId,userPayPassword))!=null?true:false;
    }

    @Override
    public boolean findByUserIdAndUserPayPassWord(Integer userId, String userPayPassword) {
        return userResponsitory.findByUserIdAndUserPayPassword(userId,userPayPassword)!=null?true:false;
    }

    @Override
    public AgricultureUser findUserName(String userName) {
        return userDao.findUserName(userName);
    }


    @Override
    public boolean updatePayPassword(AgricultureUser agricultureUser) {
        return userDao.updatPayPassword(agricultureUser)>0?true:false;
    }


}