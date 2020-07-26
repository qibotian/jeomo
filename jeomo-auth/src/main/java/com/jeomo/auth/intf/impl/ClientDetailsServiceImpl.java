package com.jeomo.auth.intf.impl;

import com.jeomo.auth.domain.OAuthClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {


    @Autowired
    public BCryptPasswordEncoder passwordEncoder;


    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        if("client_1".equals(clientId)){
            OAuthClient clientA = new OAuthClient();
            clientA.setClientId("client_1");
            clientA.setClientSecret(passwordEncoder.encode("123456"));
            //clientA.setRegisteredRedirectUri("http://www.baidu.com");
            clientA.setAccessTokenValiditySeconds(5*60);
            clientA.setRefreshTokenValiditySeconds(5*60);
        }
        throw new ClientRegistrationException("客户端不存在");
    }
}
