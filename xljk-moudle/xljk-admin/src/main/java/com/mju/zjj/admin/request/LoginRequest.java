package com.mju.zjj.admin.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/19 23:12
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    private String username;
    private String password;
    private String verId;
    private String verCode;
}
