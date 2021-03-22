package com.mju.zjj.admin.controller;

import com.mju.zjj.admin.biz.IAuthBiz;
import com.mju.zjj.admin.request.LoginRequest;
import com.mju.zjj.auth.constants.AuthConstants;
import com.mju.zjj.auth.exception.AdminTokenNotFindException;
import com.mju.zjj.common.response.BaseResponse;
import com.mju.zjj.common.response.ObjectResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/19 22:57
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private IAuthBiz authBiz;

    @Autowired
    private HttpServletRequest request;


    @PostMapping("/login")
    public ObjectResponse login(@RequestBody LoginRequest loginRequest){
        String token = authBiz.login(loginRequest.getUsername(), loginRequest.getPassword(), loginRequest.getVerId(), loginRequest.getVerCode());
        return ObjectResponse.success(token);
    }

    @PostMapping("/refresh")
    public ObjectResponse refresh(){
        String newToken = authBiz.refresh(getHeaderToken());
        return ObjectResponse.success(newToken);
    }

    @PostMapping("/verify")
    public BaseResponse verify(){
        authBiz.verify(getHeaderToken());
        return BaseResponse.ok();
    }

    private String getHeaderToken(){
        String adminToken = request.getHeader(AuthConstants.ADMIN_TOKEN_HEADER);
        if(StringUtils.isEmpty(adminToken)){
            throw new AdminTokenNotFindException("错误,token 信息为空");
        }
        return adminToken;
    }



}
