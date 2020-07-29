package com.jeomo.shiro.config;

import com.jeomo.shiro.bean.MySessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qbt
 * @Date: 2020/7/26 22:10
 * @Version 1.0
 */
public class ShiroBaseConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("mySecurityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterMap = new HashMap<String, String>();
        /*  添加shiro的内置过滤器
                anon 无需认证就可以访问
                authc  必须认证才能访问
                user  必须拥有记住我功能 才能用
                perms  拥有对某个用户资源才能访问
                role   拥有某个角色权限才能访问
         */
        filterMap.put("/auth/toLogin", "anon"); //登录页面
        filterMap.put("/auth/doLogin", "anon"); //登录操作
        filterMap.put("/auth/logout", "anon"); //退出操作
        filterMap.put("/auth/error", "anon"); //认证失败操作
        filterMap.put("/**", "authc");

        //登录地址配置为网关条件下的登录地址
        shiroFilterFactoryBean.setLoginUrl("http://localhost:9527/auth/toLogin");
        //首页
        shiroFilterFactoryBean.setSuccessUrl("/auth/success");
        //错误页面，认证不通过跳转
       shiroFilterFactoryBean.setUnauthorizedUrl("/auth/error");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return  shiroFilterFactoryBean;
    }

    /**
     * cookie管理对象;
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager(@Qualifier("rememberMeCookie") SimpleCookie rememberMeCookie){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie);
        return cookieRememberMeManager;
    }


    @Bean
    public SimpleCookie rememberMeCookie(){
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(259200);
        simpleCookie.setHttpOnly(true);
        return simpleCookie;
    }

    /**
     * redisSession管理器
     */
    @Bean(name="mySessionManager")
    public DefaultWebSessionManager sessionManager(@Qualifier("redisSessionDAO") RedisSessionDAO redisSessionDAO) {
        // 用于Web环境的实现，可以替代ServletContainerSessionManager(web默认的)，自己维护着会话，直接废弃了 Servlet 容器的会话管理。
        DefaultWebSessionManager sessionManager = new MySessionManager();
        //sessionManager.setSessionIdCookieEnabled(false); 这里可以禁用Cookie,禁用后需要显式传递sessionId
        sessionManager.setSessionDAO(redisSessionDAO);
        return sessionManager;
    }

    /**
     * redisSessionDao
     * @return
     */
    @Bean
    public RedisSessionDAO redisSessionDAO(@Qualifier("redisManager") RedisManager redisManager) {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager);
        return redisSessionDAO;
    }


    /**
     * 定义一个redis缓存管理器
     * @return
     */
    @Bean(name = "myCacheManager")
    public RedisCacheManager cacheManager(@Qualifier("redisManager") RedisManager redisManager) {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager);
        return redisCacheManager;
    }
    /**
     * 配置shiro redisManager
     * @return
     */
    @Bean
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost("localhost"); //TODO 这里最好用配置方式写
        redisManager.setPort(6379);
        return redisManager;
    }


    // Shiro 和 Spring AOP 整合时的特殊设置
    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }


}
