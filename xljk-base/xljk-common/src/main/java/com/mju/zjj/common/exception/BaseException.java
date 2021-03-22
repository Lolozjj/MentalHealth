package com.mju.zjj.common.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/19 14:36
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@NoArgsConstructor
public class BaseException extends RuntimeException {
    @Getter
    @Setter
    private int status = 200;

    public BaseException(String message, int status) {
        super(message);
        this.status = status;
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
