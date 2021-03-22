package com.mju.zjj.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/19 14:37
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    private Object id;

    private Date crtTime;

    private Integer crtUser;

    private String crtName;

    private String crtHost;

    private Date updTime;

    private Integer updUser;

    private String updName;

    private String updHost;

    private String attr1;

    private String attr2;

    private String attr3;

    private String attr4;
}
