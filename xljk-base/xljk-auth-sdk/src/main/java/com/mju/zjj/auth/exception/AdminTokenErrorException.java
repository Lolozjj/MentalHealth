package com.mju.zjj.auth.exception;

import com.mju.zjj.common.exception.BaseException;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/20 22:59
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class AdminTokenErrorException extends BaseException {
    public AdminTokenErrorException(String message) {
        super(message);
    }
}
