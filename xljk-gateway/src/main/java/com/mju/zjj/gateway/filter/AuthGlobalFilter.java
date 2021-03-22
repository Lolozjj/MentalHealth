package com.mju.zjj.gateway.filter;

import com.mju.zjj.auth.constants.AuthConstants;
import com.mju.zjj.auth.exception.AdminTokenErrorException;
import com.mju.zjj.auth.exception.AdminTokenNotFindException;
import com.mju.zjj.auth.utils.IJwtUtil;
import com.mju.zjj.gateway.rest.AuthRest;
import io.jsonwebtoken.Jwt;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/20 23:26
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@Component
@Slf4j
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    private AuthRest authRest;

    private List<String> noVerifyUri(){
        return Arrays.asList("/auth/login",
                "/captcha"
        );
    }

    @Autowired
    private IJwtUtil jwtUtil;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        URI uri = request.getURI();
        if(noVerifyUri().contains(uri.getPath())){
            return chain.filter(exchange);
        }
        HttpHeaders headers = request.getHeaders();
        String token = headers.getFirst(AuthConstants.ADMIN_TOKEN_HEADER);
        if(StringUtils.isEmpty(token)){
            throw new AdminTokenNotFindException("未检测到token");
        }
        if(!jwtUtil.verifyToken(token)){
            throw new AdminTokenErrorException("非法token");
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
