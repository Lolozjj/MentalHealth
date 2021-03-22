package com.mju.zjj.admin.biz.impl;

import com.alibaba.druid.util.Base64;
import com.alibaba.druid.util.StringUtils;
import com.mju.zjj.admin.biz.ICaptchaBiz;
import com.mju.zjj.admin.exception.CaptchaException;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/20 14:40
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@Service
public class CaptchaBiz implements ICaptchaBiz {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final int CAPTCHA_WIDTH = 130;
    private static final int CAPTCHA_HEIGHT = 48;
    private static final int CAPTCHA_LENGTH = 4;
    private static final int CAPTCHA_FONT_SIZE=32;

    private static final String CAPTCHA_VERDANA ="Verdana";
    @Override
    public Map captcha() {
        SpecCaptcha specCaptcha = new SpecCaptcha(CAPTCHA_WIDTH, CAPTCHA_HEIGHT, CAPTCHA_LENGTH);
        // 设置字体
        specCaptcha.setFont(new Font(CAPTCHA_VERDANA, Font.PLAIN, CAPTCHA_FONT_SIZE));
        // 设置类型，纯数字、纯字母、字母数字混合
        specCaptcha.setCharType(Captcha.TYPE_ONLY_NUMBER);
        String uuid = UUID.randomUUID().toString();
        String text = specCaptcha.text().toLowerCase();
        stringRedisTemplate.opsForValue().set(
                String.format(REDIS_KEY_CAPTCHA, uuid),
                text,
                LOGIN_CAPTCHA_EXPIRATION,
                TimeUnit.MINUTES
        );
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        // 输出图片流
        specCaptcha.out(stream);
        String captcha = Base64.byteArrayToBase64(stream.toByteArray());
        Map map = new HashMap<>(2);
        map.put("captcha", captcha);
        map.put("uuid", uuid);
        return map;
    }

    @Override
    public boolean verify(String uuid,String verCode) {
        String trueCode = stringRedisTemplate.opsForValue().get(String.format(REDIS_KEY_CAPTCHA, uuid));
        if(StringUtils.isEmpty(trueCode)){
            throw new CaptchaException("验证码错误");
        }
        if(!verCode.equals(trueCode)){
            throw new CaptchaException("验证码错误");
        }
        return true;
    }
}
