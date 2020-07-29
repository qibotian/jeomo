package com.jeomo.shiro.config;

import com.jeomo.shiro.bean.CustomizedModularRealmAuthenticator;
import com.jeomo.shiro.bean.ManageUserRealm;
import com.jeomo.shiro.bean.NormalUserRealm;
import com.jeomo.shiro.bean.OpenApiUserRealm;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qbt
 * @Date: 2020/7/26 22:10
 * @Version 1.0
 */
@Configuration
public class ShiroServiceConfig extends ShiroBaseConfig {

    @Autowired
    private ManageUserRealm manageUserRealm;

    @Autowired
    private NormalUserRealm normalUserRealm;

    @Autowired
    private OpenApiUserRealm openApiUserRealm;



    @Bean(name="mySecurityManager")
    public DefaultWebSecurityManager securityManager(
            @Qualifier("myCacheManager") CacheManager cacheManager,
            @Qualifier("mySessionManager") SessionManager sessionManager,
            @Qualifier("rememberMeManager") RememberMeManager rememberMeManager
    ) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        System.out.println("************************配置Realm************************");
        //这里设置自己的认证器
        List<Realm> realms = new ArrayList<>();
        realms.add(manageUserRealm); //新增管理员用户登录认证
        realms.add(normalUserRealm); //新增普通用户登录认证
        realms.add(openApiUserRealm); //新增openApi认证
        CustomizedModularRealmAuthenticator authenticator = new CustomizedModularRealmAuthenticator();
        securityManager.setRealms(realms);
        authenticator.setRealms(realms);
        //设置认证器
        securityManager.setAuthenticator(authenticator);

        //用了redis缓存注入安全管理器
        securityManager.setCacheManager(cacheManager);

        //将session托管给redis，nigix试验分布式，确实 做到了session共享
        securityManager.setSessionManager(sessionManager);

        //注入记住我管理器;
        securityManager.setRememberMeManager(rememberMeManager);

        return securityManager;
    }

}
