package com.jeomo.shiro.endpoints;

import com.jeomo.common.util.BeanCopyUtil;
import com.jeomo.shiro.bean.CustomizedUsernamePasswordToken;
import com.jeomo.shiro.dto.UserDto;
import com.jeomo.shiro.vo.UserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: qbt
 * @Date: 2020/7/26 22:12
 * @Version 1.0
 */
@RestController
@RequestMapping("/auth")
public class ShiroEndPoints {

    /**
     * 提示登录信息
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "请登录";
    }

    /**
     * 自定义登录过程
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/doLogin")
    public UserVo doLogin(@RequestParam String username, @RequestParam String password, @RequestParam(defaultValue = "MANAGE") String loginType) {
        Subject subject = SecurityUtils.getSubject();
        CustomizedUsernamePasswordToken token = new CustomizedUsernamePasswordToken(username, password, loginType);
        subject.login(token);
        UserDto user = (UserDto)(subject.getPrincipal());
        return parseDto2Vo(user);
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "您已退出登录，欢迎再来! ε=(´ο｀*)))";
    }

    /**
     * 登录成功
     * @return
     */
    @RequestMapping("/success")
    public String authSuccess() {
        Subject subject = SecurityUtils.getSubject();
        return "(*´▽｀)ノノ，认证成功！欢迎您：" + subject;
    }

    /**
     * 认证失败
     * @return
     */
    @RequestMapping("/error")
    public String authError() {
        Subject subject = SecurityUtils.getSubject();
        return "ε=(´ο｀*)))，认证失败！";
    }


    /**
     * @return
     */
    @RequestMapping("/user/info")
    public UserVo user() {
        UserDto user = (UserDto)(SecurityUtils.getSubject().getPrincipal());
        return parseDto2Vo(user);
    }


    private UserVo parseDto2Vo(UserDto userDto) {
        if(userDto != null) {
            UserVo userVo = new UserVo();
            BeanCopyUtil.copyProperties(userDto, userVo);
            return userVo;
        }
        return null;
    }


}
