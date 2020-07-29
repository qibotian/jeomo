package com.jeomo.shiro.api;

import com.jeomo.shiro.vo.BaseAuthorityVo;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * shiro授权服务
 * @Author: qbt
 * @Date: 2020/7/26 23:26
 * @Version 1.0
 */
public interface ShiroAuthorityService {

    //这个没有权限
    @GetMapping("/getAuthorityByUsername")
    public List<BaseAuthorityVo> getAuthorityByUser(String username);
}
