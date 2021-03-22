package com.mju.zjj.common.service;

import com.mju.zjj.common.entity.BaseEntity;

import java.util.List;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/19 14:41
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public interface BaseService<T extends BaseEntity> {

    T selectById(Object id);

    T selectOne(T data);

    List<T> selectBySelective(T data);

    List<T> selectAll();

    Long selectCountAll();

    Long selectCountBySelective(T data);

    /***********************************************/

    boolean insert(T data);
    boolean insertBySelective(T data);
    boolean insertBatch(List<T> data);

    /*************************************************/

    boolean update(T data);
    boolean updateBySelective(T data);
    boolean updateBatch(List<T> data);

    /************************************************/

    boolean deleteById(Object id);
    boolean deleteBySelective(T date);
}
