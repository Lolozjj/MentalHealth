package com.mju.zjj.admin.enetity;

import com.mju.zjj.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/19 15:53
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminMenu extends BaseEntity {
    private String name;
    private String des;
    private String title;
    private String href;
    private String icon;
    private String path;
    private String type;
    private Object parentId;

}
