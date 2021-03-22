package com.mju.zjj.admin.enetity;

import com.mju.zjj.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/14 11:13
 * @description： 用户角色表
 * @modified By：
 * @version: 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminRole extends BaseEntity {
    private Integer id;
    private String name;
    private String des;
}
