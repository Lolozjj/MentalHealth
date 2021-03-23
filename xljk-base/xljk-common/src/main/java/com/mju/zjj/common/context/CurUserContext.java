package com.mju.zjj.common.context;

import com.mju.zjj.common.entity.CurUserInfo;
import org.springframework.beans.BeanUtils;

import java.util.Date;


/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/22 16:38
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class CurUserContext {
    private static ThreadLocal<CurUserInfo> threadLocal=new ThreadLocal<>();

    public static void set(CurUserInfo curUserInfo){
        threadLocal.set(curUserInfo);
    }

    /**
     * 将非空属性写进threadLocal
     * @param newInfo
     */
    public static void add(CurUserInfo newInfo){
        CurUserInfo curUserInfo = get();
        BeanUtils.copyProperties(newInfo,curUserInfo);
        set(curUserInfo);
    }
    public static CurUserInfo get(){
        CurUserInfo entity = threadLocal.get();
        if(entity==null){
            entity=new CurUserInfo();
            threadLocal.set(entity);
        }
        return entity;
    }

    public static void remove(){
        threadLocal.remove();
    }

    public static void main(String[] args) {
        CurUserContext.set(new CurUserInfo(new Date(),1,"","1.1.11"));
        System.out.println(CurUserContext.get());
    }

}
