package com.jeomo.auth.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class OAuthClient implements ClientDetails, Serializable {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -3555674913099118797L;

    /**
     * 客户端ID
     */
    String clientId;

    /**
     * 此客户端可以访问的资源。如果为空，则可被调用方忽略
     */
    Set<String> resourceIds;

    /**
     * 验证此客户端是否需要认证。也就是说，如果不需要认证，则会忽略client_secret的校验
     *
     */
    boolean secretRequired;

    /**
     * 客户端密码（是否有效，与secretRequired有关）
     *
     */
    String clientSecret;

    /**
     * 此客户端是否限于特定范围。如果为false，则将忽略身份验证请求的作用域
     */
    boolean scoped;

    /**
     * 此客户端的范围。如果客户端没有作用域，则为空
     */
    Set<String> scope;

    /**
     * 为此客户端授权的授予类型
     */
    Set<String> authorizedGrantTypes;

    /**
     * 此客户端在“authorization_code”访问授予期间使用的预定义重定向URI。
     */
    Set<String> registeredRedirectUri;

    /**
     * 返回授予OAuth客户端的权限。请注意，这些权限不是使用授权访问令牌授予用户的权限。相反，这些权限是客户本身固有的。
     */
    Collection<GrantedAuthority> authorities;

    /**
     * 此客户端的访问令牌有效期，单位：秒；
     */
    Integer accessTokenValiditySeconds;

    /**
     * 此客户端的刷新令牌有效期，单位：秒；
     */
    Integer refreshTokenValiditySeconds;

    /**
     * 附加信息，非必填的
     */
    Map<String, Object> additionalInformation;


    @Override
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(Set<String> resourceIds) {
        this.resourceIds = resourceIds;
    }

    @Override
    public boolean isSecretRequired() {
        return secretRequired;
    }

    public void setSecretRequired(boolean secretRequired) {
        this.secretRequired = secretRequired;
    }

    @Override
    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    @Override
    public boolean isScoped() {
        return scoped;
    }

    public void setScoped(boolean scoped) {
        scoped = scoped;
    }

    @Override
    public Set<String> getScope() {
        return scope;
    }

    public void setScope(Set<String> scope) {
        this.scope = scope;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(Set<String> authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return registeredRedirectUri;
    }

    public void setRegisteredRedirectUri(Set<String> registeredRedirectUri) {
        this.registeredRedirectUri = registeredRedirectUri;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValiditySeconds;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return false;
    }

    public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(Map<String, Object> additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}
