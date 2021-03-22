package com.mju.zjj.admin.controller;

import com.mju.zjj.admin.biz.impl.CaptchaBiz;
import com.mju.zjj.admin.request.CaptchaValRequest;
import com.mju.zjj.common.response.BaseResponse;
import com.mju.zjj.common.response.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/13 8:54
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@RestController
public class CaptchaController {
    @Autowired
    private CaptchaBiz captchaBiz;

    @GetMapping("/captcha")
    public ObjectResponse captcha() throws Exception {
        Map result = captchaBiz.captcha();
        return ObjectResponse.success(result);
    }

    @PostMapping("/verify")
    public BaseResponse validate(CaptchaValRequest captchaValRequest){
        return captchaBiz.verify(captchaValRequest.getUuid(),captchaValRequest.getVerCode())?
                new BaseResponse():
                new BaseResponse(200,"验证码错误啦");
    }
}
