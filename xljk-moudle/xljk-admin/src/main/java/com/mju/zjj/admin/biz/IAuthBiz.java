package com.mju.zjj.admin.biz;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/19 23:09
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public interface IAuthBiz {
    /**
     * 登录获取验证码
     * @param username 用户名
     * @param password 密码
     * @param uuid 验证码uuid
     * @param verCode 验证码
     * @return
     */
    public String login(String username,String password,String uuid,String verCode);

    /**
     * 刷新token
     * @param token
     * @return
     */
    public String refresh(String token);

    /**
     * 验证token
     * @param token
     * @return
     */
    public boolean verify(String token);
}
