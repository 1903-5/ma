package com.qf.service.impl;

import com.qf.dao.Addressdao;
import com.qf.domain.Address;
import com.qf.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {


    @Resource
    private Addressdao addressdao;

    @Override
    public List<Address> findAddressByuserID(Integer userId) {
        return addressdao.findAddressByuserID(userId);
    }

    @Override
    public int deleteById(Integer id) {
        int i= addressdao.deleteById(id);
        return i>0?1:0;
    }

    @Override
    public int insertadd(String userPhone, String userAddress,String userName, Integer userId) {
        int i = addressdao.insertadd(userPhone,userAddress,userName,userId);
        return i;
    }


    @Override
    public int updateAdd(Integer userPhone, String userAddress,Integer addId) {
        int i = addressdao.updateAdd(userPhone,userAddress,addId);
        return i;
    }
}