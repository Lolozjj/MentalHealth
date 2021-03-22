package com.mju.zjj.common.service.impl;

import com.mju.zjj.common.entity.BaseEntity;
import com.mju.zjj.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/19 14:49
 * @description： 基础 增删改查
 * @modified By：
 * @version: 1.0.0
 */
public class BaseServiceImpl<T extends BaseEntity,M extends Mapper<T>> implements BaseService<T> {

    @Autowired
    private M mapper;
    @Override
    public T selectById(Object id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public T selectOne(T data) {
        return mapper.selectOne(data);
    }

    @Override
    public List<T> selectBySelective(T data) {
        return mapper.select(data);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public Long selectCountAll() {
        return (long) mapper.selectAll().size();
    }

    @Override
    public Long selectCountBySelective(T data) {
        return (long) mapper.select(data).size();
    }

    @Override
    public boolean insert(T data) {
        int insertNum = mapper.insert(data);
        return insertNum==1;
    }

    @Override
    public boolean insertBySelective(T data) {
        mapper.insertSelective(data);
        return true;
    }

    @Override
    public boolean insertBatch(List<T> data) {
        return false;
    }

    @Override
    public boolean update(T data) {
        int updateNum = mapper.updateByPrimaryKey(data);
        return updateNum==1;
    }

    @Override
    public boolean updateBySelective(T data) {
        mapper.updateByPrimaryKeySelective(data);
        return true;
    }

    @Override
    public boolean updateBatch(List<T> data) {
        return false;
    }

    @Override
    public boolean deleteById(Object id) {
        return mapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean deleteBySelective(T date) {
        mapper.delete(date);
        return true;
    }
}
