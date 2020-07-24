package com.jeomo.auth.intf.impl;

import com.jeomo.auth.domain.OAuthClient;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {

    static Map<String, OAuthClient> CLIENT_MAP = new HashMap<>();

    static {
        OAuthClient clientA = new OAuthClient();
        clientA.setClientId("client_a");
        clientA.setSecretRequired(false); //测试阶段不需要认证
        clientA.setScoped(false);
        clientA.setAccessTokenValiditySeconds(5*60);
        clientA.setRefreshTokenValiditySeconds(5*60);
        CLIENT_MAP.put("client_a", new OAuthClient());
        CLIENT_MAP.put("client_b", new OAuthClient());
    }


    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        OAuthClient client = CLIENT_MAP.get(clientId);
        if(client==null){
            throw new ClientRegistrationException("客户端不存在");
        }
        return client;
    }
}
