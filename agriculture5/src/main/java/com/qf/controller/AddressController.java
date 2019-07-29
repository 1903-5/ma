package com.qf.controller;
import com.qf.domain.Address;
import com.qf.service.AddressService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@Controller
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    //根据用户id查看所有的地址
    @ResponseBody
    @ApiOperation(value = "根据用户id查询该用户所有收货地址")
    @ApiImplicitParam(paramType = "Query",name="userId",value = "用户id",required = true)
    @RequestMapping(value = "/selectaddress",method = RequestMethod.GET)
    public List<Address> getadd(@RequestParam Integer userId){
        System.out.println(addressService.findAddressByuserID(userId));
        return addressService.findAddressByuserID(userId);
    }

    //根据地址id删除一个地址
    @ResponseBody
    @ApiOperation(value = "根据地址id删除一个收货地址")
    @ApiImplicitParam(paramType = "Query",name="id",value = "地址id",required = true)
    @RequestMapping(value = "/selectaddress",method = RequestMethod.DELETE)
    public  String deleteAdd(@RequestParam int id){
        int i = addressService.deleteById(id);

        return "删除成功";
    }

    //增加一个地址

    //增加一个地址
    @ApiOperation(value = "新增一个收货地址")
    @RequestMapping(value = "/selectaddress",method = RequestMethod.PUT)
    public  String addAdd(@RequestParam String userPhone,
                          @RequestParam String userAddress,
                          @RequestParam int userId,
                          @RequestParam String userName
    ){
        System.out.println(userPhone);
        System.out.println(userAddress);
        System.out.println(userId);

        addressService.insertadd(userPhone,userAddress,userName,userId);

        return "插入成功";
    }

    //修改
    @ResponseBody
    @ApiOperation(value = "根据地址主键修改一个收货地址的信息")
    @RequestMapping(value = "/updateaddress",method = RequestMethod.PUT)
    public  String update(@RequestParam Integer userPhone,
                          @RequestParam String userAdress,
                          @RequestParam Integer addId){

        addressService.updateAdd(userPhone,userAdress,addId);
        return "修改成功";

    }


}
