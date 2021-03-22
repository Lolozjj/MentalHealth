package com.mju.zjj.admin.controller;

import com.mju.zjj.admin.biz.impl.AdminMenuBiz;
import com.mju.zjj.admin.enetity.AdminMenu;
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
@RequestMapping("adminMenu")
@RestController
public class AdminMenuController extends BaseController<AdminMenuBiz, AdminMenu> {

}
