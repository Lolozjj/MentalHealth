package com.mju.zjj.gateway;

//import com.mju.zjj.auth.anotation.EnableAuthConfiguration;
import com.mju.zjj.gateway.utils.DBLog;
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
@EnableFeignClients({"com.mju.zjj.gateway.feign"})
public class GatewayApplication {

    public static void main(String[] args) {
        DBLog.getInstance().start();
        SpringApplication.run(GatewayApplication.class,args);
    }
}
