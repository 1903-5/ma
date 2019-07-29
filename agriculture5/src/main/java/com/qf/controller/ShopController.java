package com.qf.controller;


import com.qf.dao.ProductShopDao;
import com.qf.domain.*;
import com.qf.service.impl.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value = "/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private UserShopService userShopService;
    @Autowired
    private AgricultureProductService agricultureProductService;
    @Autowired
    private PritureService pritureService;
    @Autowired
    private ProductShopService productShopDao;
    @Autowired
    private ProductShopService productShopService;


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ApiOperation(value = "增加购物车商品",notes = "成功返回大于1;失败返回0")
    public int save(@RequestParam Integer productId,@RequestParam Integer num, @RequestParam Integer userId){
        Shop shop=new Shop();
        int i=0;
        UserShop userShop=new UserShop();
        List<UserShop> userShopList = userShopService.findByUserId(userId);
        System.out.println(userShopList+"------------------------------");
        ProductShop productShop=new ProductShop();
        AgricultureProduct product = agricultureProductService.findAllById(productId);
        System.out.println(product);
        List<AgriculturePicture> agriculturePictures = pritureService.loadByProductIdShowShop(productId);
        System.out.println(agriculturePictures);
        shop.setShopId(null);
        shop.setShopImg(agriculturePictures.get(0).getPictureUrl());
        shop.setShopTitle(product.getProductName());
        shop.setShopPrice(product.getProductPrice());
        Shop shop1 = shopService.loadByProductIdShowShop(productId);
        System.out.println(shop1);
        System.out.println(shop);
        if (userShopList==null){
            if(shop1!=null){
                shop.setShopId(shop1.getShopId());
                shop.setShopNum(shop1.getShopNum()+num);
                i = shopService.updateShop(shop);
            }else {
                shop.setShopNum(num);
                shopService.saveShop(shop);
                Integer maxShopId =shopService.getMaxShopId();
                productShop.setProid(productId);
                productShop.setSid(shopService.getMaxShopId());
                productShopDao.saveProductShop(productShop);
                userShop.setSid(shopService.getMaxShopId());
                userShop.setUsid(userId);
                System.out.println(userShop+"-----------------");
                i = userShopService.saveUserShop(userShop);
            }
        }else {
            if (shop1 != null) {
                shop.setShopId(shop1.getShopId());
                shop.setShopNum(shop1.getShopNum() + num);
                i = shopService.updateShop(shop);
            } else {
                shop.setShopNum(num);
                shopService.saveShop(shop);
                Integer maxShopId = shopService.getMaxShopId();
                productShop.setProid(productId);
                productShop.setSid(shopService.getMaxShopId());
                productShopDao.saveProductShop(productShop);
            }
            userShop.setSid(shopService.getMaxShopId());
            userShop.setUsid(userId);
            System.out.println(userShop);
            i = userShopService.saveUserShop(userShop);
        }
        return i;
    }



    @RequestMapping(value = "/loadByUserIdShowShop",method = RequestMethod.GET)
    @ApiOperation(value = "通过用户id展示购物车所有商品")
    public List<Shop> loadByUserIdShowShop(@RequestParam Integer userId){
        System.out.println(shopService.loadByUserIdShowShop(userId));
        return shopService.loadByUserIdShowShop(userId);
    }

    @RequestMapping(value = "/loadByShopIdDeleteShop",method = RequestMethod.DELETE)
    @ApiOperation(value = "通过商品id删除购物车商品")
    public int deleteShop(@RequestParam Integer shopId){
        productShopService.deleteShopProduct(shopId);
       int count= shopService.deleteShop(shopId);
        return count;
    }

    @RequestMapping(value = "/loadByShopIdUpdateShop",method = RequestMethod.POST)
    @ApiOperation(value = "修改购物车商品")
    public int updateShop(@RequestBody Shop shop){
        int count= shopService.updateShop(shop);
        return count;
    }


    @RequestMapping(value = "/loadByShopIdShowShop",method = RequestMethod.POST)
    @ApiOperation(value = "通过选中商品Id显示支付页商品")
    public List<Shop> showShop(@RequestParam String Ids){
        System.out.println(Ids);
        String [] comIds=Ids.split(",");
        System.out.println(comIds);
        List<Integer> list=new ArrayList<>();
        for( int i=0;i<comIds.length;i++){
            list.add(Integer.parseInt(comIds[i]));
        }
        System.out.println(list);
        List<Shop> shopList = shopService.loadByShopIdSshowShop(list);
        return shopList;
    }

    @RequestMapping(value = "/showProductId",method = RequestMethod.POST)
    @ApiOperation(value = "通过购物车ID显示商品ID")
    public List<ProductShop> showProductId(@RequestParam String Ids){
        System.out.println(Ids);
        String [] comIds=Ids.split(",");
        System.out.println(comIds);
        List<Integer> list=new ArrayList<>();
        for( int i=0;i<comIds.length;i++){
            list.add(Integer.parseInt(comIds[i]));
        }
        System.out.println(list);
        List<ProductShop> shopList = productShopService.loadByShopIdShowProductId(list);
        return shopList;
    }


}


