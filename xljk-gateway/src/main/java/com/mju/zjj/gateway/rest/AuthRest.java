package com.mju.zjj.gateway.rest;

import com.mju.zjj.common.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/20 23:19
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@FeignClient("XLJK-ADMIN")
@RequestMapping("/auth")
public interface AuthRest {
    @PostMapping("/verify")
    public BaseResponse verify();
}
