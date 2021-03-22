package com.mju.zjj.auth.utils;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/19 16:59
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public interface IJwtUtil {
    String createToken(Integer userId);

    Integer getUserIdByToken(String token);

    String getUserNameByToken(String token);

    boolean verifyToken(String token);
}
