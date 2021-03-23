package com.mju.zjj.common.entity;

import com.mju.zjj.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/22 13:53
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GatewayLog extends BaseEntity {
    /**
     * 请求uri
     */
    private String uri;
    /**
     * 请求host
     */
    private String host;
    /**
     * 请求所携带的参数
     */
    private String param;
    /**
     * 请求所携带的body
     */
    private String body;
    /**
     * 请求类型 get、post等
     */
    private String method;

}
