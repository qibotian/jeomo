package com.jeomo.shiro.util;

import com.jeomo.shiro.dto.UserDto;
import org.apache.shiro.SecurityUtils;

public class ShiroUtils {

    public static UserDto getCurrentLoginUser() {
        return  (UserDto)(SecurityUtils.getSubject().getPrincipal());
    }

}
