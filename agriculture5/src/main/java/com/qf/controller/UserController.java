package com.qf.controller;
import com.qf.domain.AgricultureUser;
import com.qf.service.IUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.mail.javamail.JavaMailSender;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Random;

@Controller
@ResponseBody
@RequestMapping(value = "/user")
public class UserController {

    @Value("${spring.mail.username}")
    private String MAIL_SENDER;
    @Autowired
    private IUserService userService;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private static final Logger LOG = LoggerFactory.getLogger(Logger.class);

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "增加一个用户", notes = "成功返回true;失败返回false")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userName", value = "用户账号", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "userPassword", value = "用户密码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "userEmail", value = "用户邮箱", required = true, dataType = "String")
    })
    public boolean save(@RequestParam String userName, @RequestParam String userPassword, @RequestParam String userEmail) {
        AgricultureUser u = new AgricultureUser();
        u.setUserName(userName);
        u.setUserPassword(userPassword);
        u.setUserEmail(userEmail);
        BigDecimal a=new BigDecimal(0);
        u.setUserPayPassword("123456");
        u.setUserMoney(a);
        u.setUserSex("");
        u.setUserPicture("http://pv4oyc2lb.bkt.clouddn.com/%E5%A4%B4%E5%83%8F.jpeg");
        return userService.save(u);
    }

    @RequestMapping(value = "/findByUserNameByUserPassword", method = RequestMethod.POST)
    @ApiOperation(value = "校验账号密码", notes = "正确返回true;错误返回false")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userName", value = "用户账号", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "userPassword", value = "用户密码", required = true, dataType = "String")
    })
    public AgricultureUser findByUserNameAndUserPassword(@RequestParam String userName, @RequestParam String userPassword) {
        AgricultureUser agricultureUser = userService.findByUserNameAndUserPassword(userName, userPassword);
        return agricultureUser;
    }

    @RequestMapping(value = "/findByUserName", method = RequestMethod.GET)
    @ApiOperation(value = "校验账号", notes = "存在返回true;不存在返回false")
    @ApiImplicitParam(paramType = "query", name = "userName", value = "用户账号", required = true, dataType = "String")
    public boolean findByUserName(@RequestParam String userName) {
        return userService.findByUserName(userName);
    }

    @RequestMapping(value = "/sendVerifyCode", method = RequestMethod.POST)
    @ApiOperation(value = "发送验证码", notes = "返回String类型的六位数字验证码")
    @ApiImplicitParam(paramType = "query", name = "email", value = "用户邮箱", required = true)
    //741384824@qq.com
    public String sendVerifyCode(@RequestParam String email) {
        String st = "邮件发送成功，请注意查收。";
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);

        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            //邮件发送人
            simpleMailMessage.setFrom(MAIL_SENDER);
            //邮件接收人
            simpleMailMessage.setTo(email);
            //邮件主题
            simpleMailMessage.setSubject("农业软件");
            //邮件内容
            simpleMailMessage.setText("您的验证码为:" + verifyCode + "，该码有效期为24小时，该码只能使用一次！【短信签名】");
            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            st = "服务器正在升级...";
            LOG.error("邮件发送失败", e.getMessage());
        }
        return verifyCode;
    }

    @RequestMapping(value = "/findByUserNameAndUserEmail", method = RequestMethod.GET)
    @ApiOperation(value = "校正邮箱和用户名一致", notes = "正确返回true;错误返回false")
    public boolean findByUserNameAndUserEmail(@RequestParam String userName, @RequestParam String userEmail) {
        return userService.findByUserNameAndUserEmail(userName, userEmail);
    }


    @RequestMapping(value = "/updatePaypasswordByuserId", method = RequestMethod.PUT)
    @ApiOperation(value = "根据用户id修改支付密码")
    //@ApiImplicitParam(paramType = "query",name="userName",value = "用户账号",required = true,dataType = "String")
    public String updatePaypasswordByuserId(@RequestParam String userPayPassword,
                                            @RequestParam int userId) {
        AgricultureUser agricultureUser=new AgricultureUser();
        agricultureUser.setUserPayPassword(userPayPassword);
        agricultureUser.setUserId(userId);
        userService.updatePayPassword(agricultureUser);
        return "修改成功";

    }

    @RequestMapping(value = "/findPassWord", method = RequestMethod.GET)
    @ApiOperation(value = "找回密码", notes = "给我userId和修改后的密码,返回值？true:false")
    public boolean updatePassWord(Integer userId, String userPassWord) {
        AgricultureUser u = new AgricultureUser();
        u.setUserId(userId);
        u.setUserPassword(userPassWord);
        return userService.updatePassWord(u);
    }

    @RequestMapping(value = "/updateMoney", method = RequestMethod.POST)
    @ApiOperation(value = "给用户充值")
    public boolean updateMoney(Integer userId, String userMoney,String userPayPassword ) {
        AgricultureUser u = new AgricultureUser();
        Integer aa = Integer.valueOf(userMoney).intValue();
        BigDecimal bigDecimal = BigDecimal.valueOf(aa);
        if (userService.findByUserIdAndUserPassword(userId, userPayPassword)) {
            BigDecimal a = userService.findByUserId(userId).getUserMoney();
            u.setUserId(userId);
            u.setUserMoney(bigDecimal.add(a));
        }
        return userService.updateUserMoney(u);
    }

    @RequestMapping(value = "/updatePayPassWord", method = RequestMethod.GET)
    @ApiOperation(value = "修改支付密码", notes = "给我userId修改支付密码,返回值？true:false")
    public String updatePassWord(@RequestParam Integer userId, @RequestParam String userPayPassword, @RequestParam String afterUserPayPassword){
        String result = "";
        AgricultureUser u = new AgricultureUser();
        System.out.println(userService.findByUserIdAndUserPayPassWord(userId, userPayPassword));
        System.out.println(userService.updatePayPassword(u));
        if (userService.findByUserIdAndUserPayPassWord(userId, userPayPassword)) {
            u.setUserId(userId);
            u.setUserPayPassword(afterUserPayPassword);
            if (userService.updatePayPassword(u)) {
                result = "修改成功";

            } else {
                result = "原密码错误";
            }

        }
        return result;
    }



    @RequestMapping(value = "/findByUserId", method = RequestMethod.GET)
    @ApiOperation(value = "通过用户ID查询用户所有信息", notes = "正确返回对象，错误为空")
    public AgricultureUser findByUserId (@RequestParam Integer userId ) {
        return userService.findByUserId(userId);
    }






}
