package com.qf.shiro;


import com.qf.domain.AgricultureUser;
import com.qf.service.impl.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserShiroReaml extends AuthorizingRealm {
    @Autowired
    private UserService userService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();//获取用户信息
//        char[] credentials =(char[]) token.getCredentials();
//        String password = ((char[]) token.getCredentials()).toString();//获取凭证信息
        //根据用户信息查询数据库获取后端的用户身份，转交给securityManager判定
        AgricultureUser user = userService.findUserName(username);//从数据库直接取
        System.out.println(user);
        if (user != null) {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUserName(), user.getUserPassword(), getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }

}
