package com.mju.zjj.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/19 15:18
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectResponse<T> extends BaseResponse {
    private T data;
    public ObjectResponse(BaseResponse baseResponse){
        this.code=baseResponse.code;
        this.message=baseResponse.message;
    }
    public ObjectResponse<T> data(T data){
        this.data=data;
        return this;
    }
    public static <T> ObjectResponse success(T data){
        return new ObjectResponse(BaseResponse.ok()).data(data);
    }
}
