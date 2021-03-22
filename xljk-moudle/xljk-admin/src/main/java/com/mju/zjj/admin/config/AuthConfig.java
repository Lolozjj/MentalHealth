package com.mju.zjj.admin.config;


import com.mju.zjj.auth.utils.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/19 17:27
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@Configuration
public class AuthConfig {
    @Bean
    public JwtUtil getJwtUtil(){
        return new JwtUtil();
    }
}
