package com.jeomo.shiro.bean;

import com.jeomo.shiro.dto.RoleDto;
import com.jeomo.shiro.dto.UserDto;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @Author: qbt
 * @Date: 2020/7/26 22:06
 * @Version 1.0
 */
public abstract class ShiroBaseUserRealm extends AuthorizingRealm {

    public Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 执行授权逻辑
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserDto user = (UserDto) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        List<RoleDto> roles = user.getRoles();
        for (RoleDto role : roles) {
            info.addRole(role.getCode());
        }
        return info;
    }

    /**
     * 获取加密方法
     * @return
     */
    @Bean
    public CredentialsMatcher getCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher=new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashIterations(2);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }
}
