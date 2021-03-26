package com.atguigu.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @description:
 * @author:zyz
 * @time:2021/3/25-23:16
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //定制请求授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        //开启自动登录 如果登录没有权限 没有登录就会来到这个界面
        http.formLogin();
        //1. /login请求来到登录页
        //2. 重定向到/login?error表示登陆失败
        //3. 更多详细规定


        //开启自动配置的注销
        http.logout();
    }

    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.inMemoryAuthentication()
                .passwordEncoder(new MyPasswordEncoder())
                .withUser("zhangsan").password("123456").roles("VIP1", "VIP2")
                .and()
                .withUser("lisi").password("123456").roles("VIP2", "VIP3")
                .and()
                .withUser("wangwu").password("123456").roles("VIP1", "VIP3");
    }
}
