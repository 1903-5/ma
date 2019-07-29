package com.qf.controller;

import com.qf.domain.*;
import com.qf.service.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private IOrderProductService orderProductService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IAgricultureProductSevice agricultureProductSevice;
    @Autowired
    private IOrderShowService orderShowService;
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/findOrderByUserId",method = RequestMethod.GET)
    @ApiOperation(value = "根据用户id查询用户的所有订单",notes="返回List<Order>")
    @ApiImplicitParam(paramType = "query",name="userId",value = "用户id",required = true,dataType = "String")
    public List<Order> findOrderByUserId(@RequestParam String userId){
        Integer userid=Integer.valueOf(userId).intValue();//把String转为Integer
        return orderService.findOrderIdByUserId(userid);
    }

    @RequestMapping(value = "/findOrderProductByOId",method = RequestMethod.GET)
    @ApiOperation(value = "根据订单号查询订单详细信息",notes="返回List<Order>")
    @ApiImplicitParam(paramType = "query",name="oId",value = "订单id",required = true,dataType = "String")
    public List<OrderProduct> findOrderProductByOId(@RequestParam String oId){
        return orderProductService.findOrderProductByOId(oId);
    }

    @RequestMapping(value = "/paymentOrder",method = RequestMethod.GET)
    @ApiOperation(value = "支付环节",notes="返回booleean ? 已支付(true):余额不足(false)")
    public boolean paymentOrder(@RequestParam String userId,@RequestParam String oId){
        boolean result = false;
        Integer userid=Integer.valueOf(userId).intValue(); //用户id
        AgricultureUser agricultureUser = userService.findByUserId(userid); //通过userId获得用户信息
        Order order = orderService.findOrderByOrderId(oId); //通过订单编号获得订单信息
        Order order1 = new Order();
        order1.setOrderId(oId);
        order1.setOrderState(1);//订单状态: 已付款:1;
        order1.setOrderLogistics("等待卖家发货哦");
        if ((order.getOrderPrice().compareTo(agricultureUser.getUserMoney()) == -1) || (order.getOrderPrice().compareTo(agricultureUser.getUserMoney()) == 0) ){
            BigDecimal userMoney = agricultureUser.getUserMoney().subtract(order.getOrderPrice());
            AgricultureUser user = new AgricultureUser();
            user.setUserMoney(userMoney);
            user.setUserId(userid);
            Admin admin = new Admin();
            admin.setId(1);
            admin.setMoney(adminService.loadById(1).getMoney().add(order.getOrderPrice()));
            if(userService.updateUserMoney(user) && orderService.updateOrderStateByOrderId(order1) && adminService.update(admin)){
                return result = true;}
        }
        return result;
    }

    @RequestMapping(value = "/findOrderByorderId",method = RequestMethod.GET)
    @ApiOperation(value = "根据订单状态查询匹配的订单",notes = "返回List<Order>")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "orderState", value = "订单状态(未付款(0)):((已付款)1)", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, dataType = "String")
    })
    public List<Order> findOrderByorderId(@RequestParam String userId,@RequestParam String orderState){
        Integer orderstate=Integer.valueOf(orderState).intValue();//把String转为Integer
        Integer userid=Integer.valueOf(userId).intValue();
        Order order = new Order();
        order.setUId(userid);
        order.setOrderState(orderstate);
        return orderService.findOrderByOrderState(order);
    }

    @RequestMapping(value = "/showAllOrderByuserId",method = RequestMethod.GET)
    @ApiOperation(value = "根据用户Id查出订单详细",notes="返回List<OrderShow>")
    @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, dataType = "String")
    public List<OrderShow> showAllOrderByuserId(@RequestParam("userId") String userId){
        Integer userid=Integer.valueOf(userId).intValue();
        List<OrderShow> orderShows = orderShowService.showAllOrderByuserId(userid);
        return orderShows;

    }

    @RequestMapping(value = "/saveOrder",method = RequestMethod.POST)
    @ApiOperation(value = "生成一个用户订单",notes = "成功返回true;失败返回false,,必须信息 String userId , List<OrderProduct> orderProductList")
    public boolean saveOrder(@RequestBody OrderProductReq orderProductReq){
        boolean result = false ;
        Integer userId=  orderProductReq.getUserId(); //通过参数获取用户id
        List<OrderProductList> orderProductList=orderProductReq.getOrderProductListList();
        //生成订单号
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");//当前时间
        long newDay = Long.parseLong(sdf.format(System.currentTimeMillis()));
        StringBuilder sb = new StringBuilder();
        sb = sb.append(newDay);// 在字符串结尾添加入x
        sb = sb.append(userId);// 在字符串结尾添加入y
        String orderId = ""+sb;
        List<OrderProduct> orderProducts = new ArrayList<>();
        BigDecimal orderPrice = new BigDecimal(0);
        for (int i = 0; i < orderProductList.size();i++){ //遍历orderProductList,增加订单属性
            AgricultureProduct agricultureProduct = agricultureProductSevice.findAllById(orderProductList.get(i).getPId());
            BigDecimal bigDecimal = BigDecimal.valueOf(orderProductList.get(i).getNumber()); //商品数量
            BigDecimal multiply = agricultureProduct.getProductPrice().multiply(bigDecimal); //订单总价
            orderPrice = orderPrice.add(multiply); //订单总价
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setOId(orderId);//集合里每个赋订单号
            orderProduct.setMonicker(agricultureProduct.getProductName()); //商品名字
            orderProduct.setPrice(agricultureProduct.getProductPrice()); //商品价格
            orderProduct.setNumber(orderProductList.get(i).getNumber()); //商品数量
            orderProduct.setPId(orderProductList.get(i).getPId()); //商品Id
            String url = (agricultureProduct.getAgriculturePictureList()).get(0).getPictureUrl();
            orderProduct.setPhoto(url); // 拿到商品第一个主图片url
            orderProducts.add(orderProduct);
        }
        Order order = new Order(); //new订单表
        order.setOrderId(orderId); //生成订单号
        order.setUId(userId); //用户id 外键
        order.setOrderLogistics("宝宝丫,还没付款呢"); //物流信息:未发货
        order.setOrderState(0); //订单状态:未支付:0; 已付款:1; 已发货:2; 待收货:3; 已收货:4; 未评价:5; 退款/退货:6
        order.setOrderPrice(orderPrice);
        if (orderService.save(order)) //增加订单成功，那么添加订单详情表
        {
            result = orderProductService.saveAll(orderProducts);
        }
        return result;
    }

    @RequestMapping(value = "/deleteOrder",method = RequestMethod.GET)
    @ApiOperation(value = "删除用户订单",notes="给我String类型的订单编号;;返回?true:false")
    public boolean deleteOrder(String orderId){
        boolean b = false;
        if(orderProductService.deleteOrderProduct(orderId) && orderService.deleteOrder(orderId)) {
            b = true;
        }
        return b;
    }
}

