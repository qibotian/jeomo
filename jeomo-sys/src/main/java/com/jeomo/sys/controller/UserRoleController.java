package com.jeomo.sys.controller;

import com.jeomo.common.controller.BaseController;
import com.jeomo.common.result.annotation.ResponseResult;
import com.jeomo.sys.service.IUserRoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseResult
@RequestMapping("/sys/userRole/")
@Api("用户角色管理相关api")
public class UserRoleController extends BaseController {

    @Autowired
    private IUserRoleService userRoleService;

    @PostMapping("/save")
    public boolean save(String username, String[] roleCodes) {
        userRoleService.insertUserRole(username, roleCodes);
        return true;
    }


}
