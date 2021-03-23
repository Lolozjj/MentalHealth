package com.mju.zjj.gateway.feign;

import com.mju.zjj.common.entity.GatewayLog;
import com.mju.zjj.common.response.ObjectResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/22 14:19
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@FeignClient("XLJK-ADMIN")
@RequestMapping("/gatewayLog")
public interface GatewayLogFeign {
    @PostMapping("")
    public ObjectResponse add(@RequestBody GatewayLog entity);
}
