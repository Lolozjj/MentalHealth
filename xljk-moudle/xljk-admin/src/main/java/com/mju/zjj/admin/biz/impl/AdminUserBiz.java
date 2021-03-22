package com.mju.zjj.admin.biz.impl;

import com.mju.zjj.admin.enetity.AdminUser;
import com.mju.zjj.admin.exception.UserPasswordException;
import com.mju.zjj.admin.service.AdminMenuService;
import com.mju.zjj.admin.service.AdminUserService;
import com.mju.zjj.common.biz.BaseBiz;
import org.springframework.stereotype.Service;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/19 16:01
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@Service
public class AdminUserBiz extends BaseBiz<AdminUserService> {
    public boolean verifyPassword(String username,String password){
        AdminUser adminUser=new AdminUser();
        adminUser.setUsername(username);
        adminUser.setPassword(password);
        AdminUser findResult = service.selectOne(adminUser);
        if(findResult==null){
            throw new UserPasswordException("密码错误");
        }
        return true;
    }

    public AdminUser selectByUsername(String username){
        AdminUser user=new AdminUser();
        user.setUsername(username);
        AdminUser adminUser = service.selectOne(user);
        return adminUser;
    }
}
