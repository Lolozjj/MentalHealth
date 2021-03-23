package com.mju.zjj.common.utils;

import com.mju.zjj.common.context.CurUserContext;
import com.mju.zjj.common.entity.BaseEntity;
import com.mju.zjj.common.entity.CurUserInfo;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/22 17:30
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class BaseEntityTools {
    public static void setCrtArr(BaseEntity entity){
        CurUserInfo curUserInfo = CurUserContext.get();
        ReflectionUtils.invokeSetter(entity,"crtUser",curUserInfo.getUserId());
        ReflectionUtils.invokeSetter(entity,"crtName",curUserInfo.getUserName());
        ReflectionUtils.invokeSetter(entity,"crtTime",curUserInfo.getCurTime());
        ReflectionUtils.invokeSetter(entity,"crtHost",curUserInfo.getHost());
    }

    public static void setUpdArr(BaseEntity entity){
        CurUserInfo curUserInfo = CurUserContext.get();
        ReflectionUtils.invokeSetter(entity,"updUser",curUserInfo.getUserId());
        ReflectionUtils.invokeSetter(entity,"updName",curUserInfo.getUserName());
        ReflectionUtils.invokeSetter(entity,"updTime",curUserInfo.getCurTime());
        ReflectionUtils.invokeSetter(entity,"updHost",curUserInfo.getHost());
    }
}
