package com.jeomo.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EndPoints {

    @RequestMapping("/sayHello")
    private String hello() {
        return "hello!";
    }

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

//    @RequestMapping(value = "/authenticate",method = RequestMethod.POST)
//    public Token authorize(@RequestParam String username, @RequestParam String password) {
//        // 1 创建UsernamePasswordAuthenticationToken
//        UsernamePasswordAuthenticationToken token
//                = new UsernamePasswordAuthenticationToken(username, password);
//        // 2 认证
//        Authentication authentication = this.authenticationManager.authenticate(token);
//        // 3 保存认证信息
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        // 4 加载UserDetails
//        UserDetails details = this.userDetailsService.loadUserByUsername(username);
//        // 5 生成自定义token
//        return tokenProvider.createToken(details);
//    }


}
