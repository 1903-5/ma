package com.qf.controller;
import com.qf.domain.AgricultureUser;
import com.qf.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class UserShiroController {
  /*  @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String showlogin() {
        return "login";
    }
*/
    /**
     * 登录处理
     *
     * @param map 用户登录表单数据
     * @return 逻辑视图
     */
    @RequestMapping(value = "dealLogin", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "Shiro：未登录：指定页面不能访问。")
    public Result dealLogin(@RequestParam Map<String, Object> map) {
        System.out.println(map.values().toString());
        Result result = new Result();
        AgricultureUser user = new AgricultureUser();
        String username = map.get("userName").toString();
        String password = map.get("password").toString();
        user.setUserName(username);
        user.setUserPassword(password);
        try {
            Subject subject = SecurityUtils.getSubject();//从安全管理器中获取主体对象
            UsernamePasswordToken token = new UsernamePasswordToken();//构建令牌对象
            token.setUsername(username);//赋身份信息
            token.setPassword(password.toCharArray());//赋凭证信息
            subject.login(token);//使用主体的login方法判定用户的权限
            if (subject.isAuthenticated()) {
                result.setCode("0");
                result.setMsg("登陆成功");
                result.setData(user);
            }
        } catch (IncorrectCredentialsException e) {
            result.setCode("64005");
            result.setMsg("密码错误");
        } catch (AuthenticationException e) {
            result.setCode("63001");
            result.setMsg("用户名不存在");
        }
        return result;
    }

    //    用户注销操作
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "退出安全框架")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();//登出
        return "redirect:login";
    }
}
