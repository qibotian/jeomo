package com.jeomo.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and().httpBasic();
    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 关掉服务端session
//                .and()
//                    //下边的路径放行,不需要经过认证
//                    .requestMatchers()
//                    .antMatchers("/user/**","/admin/**","/oauth/**","/login","/login-error","/sayHello")
//                .and()
//                    .authorizeRequests() //定义哪些URL需要保护或者不需要保护
//                    .antMatchers("/admin/**").hasRole("ADMIN")
//                    .antMatchers("/user/**").hasRole("USER")
//                    .antMatchers("/error","/oauth/**","/login","/login-error","/sayHello").permitAll()
//                    .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                    .anyRequest().authenticated()
//                .and()
//                    .formLogin() // 需要用户登录时，跳转到登录页面
//                    .defaultSuccessUrl("/user/info").permitAll()
//                .and()
//                .csrf().disable() //跨站请求伪造，这是一个放置跨站请求伪造的攻击的策略设置
//        ;
//    }

}
