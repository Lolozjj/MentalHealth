package com.mju.zjj.auth.anotation;


import java.lang.annotation.*;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/19 17:25
 * @description：
 * @modified By：
 * @version: 1.0.0
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface EnableAuthConfiguration {
}