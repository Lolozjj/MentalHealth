package com.mju.zjj.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/22 17:09
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurUserInfo {
    private Date curTime;
    private Integer userId;
    private String userName;
    private String host;
}
