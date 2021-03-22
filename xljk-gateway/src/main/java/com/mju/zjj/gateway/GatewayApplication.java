package com.mju.zjj.gateway;

//import com.mju.zjj.auth.anotation.EnableAuthConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/19 16:39
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@SpringBootApplication
//@EnableFeignClients
//@EnableAuthConfiguration
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }
}
