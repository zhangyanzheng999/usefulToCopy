package com.atguigu.security.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @description:
 * @author:zyz
 * @time:2021/3/25-23:34
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
    }
}
