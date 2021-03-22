package com.mju.zjj.admin.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/13 10:26
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaptchaValRequest {
    private String uuid;
    private String verCode;
}
