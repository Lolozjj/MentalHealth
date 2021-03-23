package com.mju.zjj.auth.interceptor;

import com.mju.zjj.auth.constants.AuthConstants;
import com.mju.zjj.auth.utils.JwtUtil;
import com.mju.zjj.common.context.CurUserContext;
import com.mju.zjj.common.entity.CurUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


/**
 * @author Lolo
 */
public class UserAuthRestInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(UserAuthRestInterceptor.class);
    @Autowired
    private JwtUtil jwtUtil;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 配置该注解，说明不进行用户拦截
        String token = request.getHeader(AuthConstants.ADMIN_TOKEN_HEADER);

        CurUserInfo curUserInfo=new CurUserInfo();
        curUserInfo.setHost(request.getRemoteHost());
        curUserInfo.setCurTime(new Date());
        curUserInfo.setUserId(jwtUtil.getUserIdByToken(token));
        curUserInfo.setUserName(jwtUtil.getUserNameByToken(token));
        CurUserContext.set(curUserInfo);

        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        CurUserContext.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
