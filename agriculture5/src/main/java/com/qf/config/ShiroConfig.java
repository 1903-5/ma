package com.qf.config;


import com.qf.shiro.UserShiroReaml;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        Map<String, String> map = new HashMap<>();
        map.put("/*", "authc");  //必须登录才可访问
        //map.put("/one","perms[user_edit]");//只有特定权限（“user_edit”）的用户登录后才可访问
        //map.put("/two","perms[user_forbidden]");//只有特定权限（“user_forbidden”）的用户登录后才可访问
        shiroFilterFactoryBean.setLoginUrl("/*");//设置登录页（匿名）
        /*shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");//权限不足的错误提示页*/
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);//装配拦截策略
        return shiroFilterFactoryBean;
    }

    //    配置安全管理器（注入Realm对象）
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userShiroReaml") UserShiroReaml userShiroReaml) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userShiroReaml);
        return defaultWebSecurityManager;
    }

    @Bean(name = "userShiroReaml")  //使用该注解是的Realm对象由spring容器管理
    public UserShiroReaml userShiro() {
        UserShiroReaml userShiroReaml = new UserShiroReaml();
        return userShiroReaml;
    }

    /**
     * 开启Shiro注解(如@RequiresRoles,@RequiresPermissions),
     * 需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    /**
     * 开启aop注解支持
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager defaultWebSecurityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(defaultWebSecurityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
