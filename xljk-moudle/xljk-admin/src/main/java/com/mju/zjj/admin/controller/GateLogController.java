package com.mju.zjj.admin.controller;

import com.mju.zjj.admin.biz.impl.GatewayLogBiz;
import com.mju.zjj.common.entity.GatewayLog;
import com.mju.zjj.common.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/22 14:08
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@RestController
@RequestMapping("gatewayLog")
public class GateLogController extends BaseController<GatewayLogBiz, GatewayLog> {
}
