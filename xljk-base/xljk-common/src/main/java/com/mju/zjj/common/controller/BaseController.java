package com.mju.zjj.common.controller;

import com.mju.zjj.common.biz.BaseBiz;
import com.mju.zjj.common.entity.BaseEntity;
import com.mju.zjj.common.response.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/19 15:07
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@ResponseBody
public class BaseController <Biz extends BaseBiz,T extends BaseEntity> {

    @Autowired
    private Biz biz;

    @PostMapping("")
    public ObjectResponse<T> add(@RequestBody T entity){
        biz.insertSelective(entity);
        return new ObjectResponse<T>();
    }

    @DeleteMapping("/{id}")
    public ObjectResponse<T> delete(@PathVariable int id){
        biz.deleteById(id);
        return new ObjectResponse<T>();
    }

    @PutMapping("")
    public ObjectResponse<T> update(@RequestBody T entity){
        biz.updateSelective(entity);
        return new ObjectResponse<>();
    }

    @GetMapping("/{id}")
    public ObjectResponse selectById(@PathVariable int id){
        BaseEntity entity = biz.selectById(id);
        return ObjectResponse.success(entity);
    }

    @GetMapping("/all")
    public ObjectResponse selectAll(){
        List list = biz.selectAll();
        return ObjectResponse.success(list);
    }

}
