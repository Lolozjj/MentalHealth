package com.mju.zjj.admin.biz;

import java.util.Map;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/20 14:38
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public interface ICaptchaBiz {
    String REDIS_KEY_CAPTCHA = "admin:captcha:%s";
    int LOGIN_CAPTCHA_EXPIRATION =2;

    public Map captcha();

    public boolean verify(String uuid,String verCode);
}
