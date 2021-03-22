package com.mju.zjj.admin.controller;

import com.mju.zjj.admin.biz.impl.AdminRoleBiz;
import com.mju.zjj.admin.enetity.AdminRole;
import com.mju.zjj.common.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/19 16:05
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@RequestMapping("adminRole")
@RestController
public class AdminRoleController extends BaseController<AdminRoleBiz, AdminRole> {

}
