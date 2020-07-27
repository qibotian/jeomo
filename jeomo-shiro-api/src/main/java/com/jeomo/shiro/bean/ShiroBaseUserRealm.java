package com.jeomo.shiro.bean;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: qbt
 * @Date: 2020/7/26 22:06
 * @Version 1.0
 */
public abstract class ShiroBaseUserRealm extends AuthorizingRealm {

    public Logger logger = LoggerFactory.getLogger(getClass());
    public static final Map<String, User> MOMERY_USER = new HashMap<String, User>(2);
    public static final Set<String> tomRoleNameSet = new HashSet<>();
    public static final Set<String> tomPermissionNameSet = new HashSet<>();
    public static final Set<String> jerryRoleNameSet = new HashSet<>();
    public static final Set<String> jerryPermissionNameSet = new HashSet<>();

    static {
        User tom = new User();
        tom.setUsername("tom");
        tom.setPassword("4280d89a5a03f812751f504cc10ee8a5"); //加密后的密码 源码123456
        MOMERY_USER.put("tom", tom);

        User jerry = new User();
        jerry.setUsername("jerry");
        jerry.setPassword("4280d89a5a03f812751f504cc10ee8a5");
        MOMERY_USER.put("jerry", jerry);

        tomRoleNameSet.add("ADMIN");
        tomRoleNameSet.add("USER");
        jerryRoleNameSet.add("USER");
        tomPermissionNameSet.add("resource:insert");
        tomPermissionNameSet.add("resource:update");
        tomPermissionNameSet.add("resource:delete");
        tomPermissionNameSet.add("resource:query");
        jerryPermissionNameSet.add("resource:query");
    }

    /**
     * 执行授权逻辑
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("***********************进入授权阶段***********************");
        User user = (User) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        if (user.getUsername().equals("tom")) {
            info.addRoles(tomRoleNameSet);
            info.addStringPermissions(tomPermissionNameSet);
        } else if (user.getUsername().equals("jerry")) {
            info.addRoles(jerryRoleNameSet);
            info.addStringPermissions(jerryPermissionNameSet);
        }
        return info;
    }

    @Override
    public CredentialsMatcher getCredentialsMatcher() {
        return credentialsMatcher();
    }

    @Bean
    public HashedCredentialsMatcher credentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher=new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashIterations(2);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }
}
