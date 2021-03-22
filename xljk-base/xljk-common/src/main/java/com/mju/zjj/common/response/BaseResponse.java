package com.mju.zjj.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/19 15:11
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    public int code=OK_CODE;
    public String message;

    protected static int OK_CODE=200;
    protected static int FAIL_CODE=500;

    public BaseResponse code(int code){
        this.code=code;
        return this;
    }

    public BaseResponse message(String message){
        this.message=message;
        return this;
    }

    public static BaseResponse ok(){
        return new BaseResponse().code(OK_CODE);
    }
    public static BaseResponse ok(String msg){
        return BaseResponse.ok().message(msg);
    }
    public static BaseResponse fail(){
        return new BaseResponse().code(FAIL_CODE);
    }
    public static BaseResponse fail(int code){
        return new BaseResponse().code(code);
    }
    public static BaseResponse fail(String msg){
        return BaseResponse.fail().message(msg);
    }
}
