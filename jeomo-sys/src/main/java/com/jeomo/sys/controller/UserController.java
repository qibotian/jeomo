package com.jeomo.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeomo.common.controller.BaseController;
import com.jeomo.common.result.annotation.ResponseResult;
import com.jeomo.sys.entity.User;
import com.jeomo.sys.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
@RestController
@ResponseResult
@RequestMapping("/sys/user")
@Api("用户管理相关api")
public class UserController extends BaseController {

    @Autowired
    IUserService userService;

    @ApiOperation("获取用户详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="path",name="id",dataType="String",required=true,value="用户Id"),
    })
    @PostMapping("/{id}")
    public User get(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping("/detail/{id}")
    public User detail(@PathVariable Long id) {
        return userService.findUserAllInfoById(id);
    }

    @PostMapping("/del/{id}")
    public boolean del(@PathVariable Long id) {
        return userService.removeById(id);
    }

    @PostMapping("/save")
    public boolean save(@RequestBody User user) {
       return userService.save(user);
    }

    @PostMapping("/update")
    public boolean update(@RequestBody User user) {
        return userService.updateById(user);
    }

    @PostMapping("/find/{loginName}")
    public User selectByLoginName(@PathVariable String loginName) {
        return userService.findUserByLoginName(loginName);
    }


}
