package com.mju.zjj.admin.biz.impl;

import com.mju.zjj.admin.biz.IAuthBiz;
import com.mju.zjj.admin.enetity.AdminUser;
import com.mju.zjj.auth.constants.AuthConstants;
import com.mju.zjj.auth.exception.AdminTokenNotFindException;
import com.mju.zjj.auth.utils.IJwtUtil;
import com.mju.zjj.auth.utils.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/19 22:59
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@Service
public class AuthBiz implements IAuthBiz {
    @Autowired
    private IJwtUtil jwtUtil;

    @Autowired
    private AdminUserBiz adminUserBiz;
    @Autowired
    private CaptchaBiz captchaBiz;

    @Override
    public String login(String username, String password, String uuid, String verCode) {
        boolean isTruePassword = adminUserBiz.verifyPassword(username, password);
        AdminUser adminUser = adminUserBiz.selectByUsername(username);
        boolean isTrueCaptcha = captchaBiz.verify(uuid, verCode);
        if(isTrueCaptcha&& isTruePassword){
            return jwtUtil.createToken((Integer) adminUser.getId());
        }
        return "";
    }

    @Override
    public String refresh(String token) {
        Integer userId = jwtUtil.getUserIdByToken(token);
        String newToken = jwtUtil.createToken(userId);
        return newToken;
    }

    @Override
    public boolean verify(String token) {
        return jwtUtil.verifyToken(token);
    }


}
