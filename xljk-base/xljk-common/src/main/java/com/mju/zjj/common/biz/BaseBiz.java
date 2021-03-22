package com.mju.zjj.common.biz;

import com.mju.zjj.common.entity.BaseEntity;
import com.mju.zjj.common.response.BaseResponse;
import com.mju.zjj.common.response.ObjectResponse;
import com.mju.zjj.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/19 15:03
 * @description： 应用测服务
 * @modified By：
 * @version: 1.0.0
 */
public class BaseBiz<Ser extends BaseService> {
    @Autowired
    protected Ser service;


    public <T extends BaseEntity> void insertSelective(T entity) {
        service.insertBySelective(entity);
    }

    public void deleteById(int id) {
        service.deleteById(id);
    }

    public <T extends BaseEntity> void updateSelective(T entity) {
        service.updateBySelective(entity);
    }

    public BaseEntity selectById(int id) {
        BaseEntity entity = service.selectById(id);
        return entity;
    }

    public List selectAll() {
        List all = service.selectAll();
        return all;
    }
}
