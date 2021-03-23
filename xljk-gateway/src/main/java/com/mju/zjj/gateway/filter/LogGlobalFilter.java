package com.mju.zjj.gateway.filter;

import com.mju.zjj.common.context.CurUserContext;
import com.mju.zjj.common.entity.CurUserInfo;
import com.mju.zjj.common.entity.GatewayLog;
import com.mju.zjj.gateway.feign.GatewayLogFeign;
import com.mju.zjj.gateway.utils.DBLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/20 23:26
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@Component
@Slf4j
public class LogGlobalFilter implements GlobalFilter, Ordered {


    @Autowired
    private GatewayLogFeign logFeign;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        GatewayLog gatewayLog=new GatewayLog();
        gatewayLog.setUri(request.getURI().getPath());
        gatewayLog.setHost(request.getURI().getHost());
        gatewayLog.setMethod(request.getMethodValue());
        gatewayLog.setParam(request.getQueryParams().toString());
        String body = String.valueOf(exchange.getAttributes().get("requestBodyAttr"));
        gatewayLog.setBody(body);
//        DBLog.getInstance().setLogService(logFeign).offerQueue(gatewayLog);

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 100;
    }
}
