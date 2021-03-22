package com.mju.zjj.auth.exception;

import com.mju.zjj.common.exception.BaseException;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/19 14:36
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class AdminTokenNotFindException extends BaseException {
    public AdminTokenNotFindException(String message) {
        super(message);
    }
}
