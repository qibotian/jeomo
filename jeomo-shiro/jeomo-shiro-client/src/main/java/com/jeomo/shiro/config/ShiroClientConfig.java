package com.jeomo.shiro.config;

import com.jeomo.shiro.bean.ShiroBaseUserRealm;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: qbt
 * @Date: 2020/7/27 17:34
 * @Version 1.0
 */
@Configuration
public class ShiroClientConfig extends ShiroBaseConfig {


    @Bean(name="mySecurityManager")
    @ConditionalOnMissingBean
    public DefaultWebSecurityManager securityManager(
            @Qualifier("shiroUserRealm") ShiroBaseUserRealm realm,
            @Qualifier("myCacheManager") CacheManager cacheManager,
            @Qualifier("mySessionManager") SessionManager sessionManager,
            @Qualifier("rememberMeManager") RememberMeManager rememberMeManager
    ) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        //这里注入的实际是客户端自己的realm
        securityManager.setRealm(realm);
        //用了redis缓存注入安全管理器
        securityManager.setCacheManager(cacheManager);

        //将session托管给redis，nigix试验分布式，确实 做到了session共享
        securityManager.setSessionManager(sessionManager);

        //注入记住我管理器;
        securityManager.setRememberMeManager(rememberMeManager);

        return securityManager;
    }


}
