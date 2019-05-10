package com.jeomo.com.jeomo.shiro;

import org.springframework.web.server.session.DefaultWebSessionManager;

/**
 * @Author: qbt
 * @Date: 2019/5/3 17:55
 * @Version 1.0
 */
public class MySessionManager extends DefaultWebSessionManager {

    private static final String AUTHORIZATION = "Authorization";

    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";

    public MySessionManager() {
        super();
    }

}
