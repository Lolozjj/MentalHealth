package com.mju.zjj.admin.enetity;

import com.mju.zjj.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/13 10:48
 * @description： 管理员用户表
 * @modified By：
 * @version: 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminUser extends BaseEntity {

    /**
     * 管理员 编号
     */
    private String no;
    /**
     * 用户名 登录账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别 0 女 1 男
     */
    private Integer sex;
    /**
     * 头像地址
     */
    private String imgUrl;
    /**
     * 手机号
     */
    private String phone;



}
