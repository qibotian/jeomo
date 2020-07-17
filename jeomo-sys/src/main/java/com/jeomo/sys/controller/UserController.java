package com.jeomo.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeomo.common.controller.BaseController;
import com.jeomo.common.result.annotation.ResponseResult;
import com.jeomo.common.util.BeanCopyUtil;
import com.jeomo.sys.dto.UserDto;
import com.jeomo.sys.entity.User;
import com.jeomo.sys.service.IUserService;
import com.jeomo.sys.vo.UserVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

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
    	@ApiImplicitParam(paramType="path",name="username",dataType="String", required=true, value="用户名"),
    })
    @GetMapping("/info/{username}")
    public UserVo detail(@PathVariable String username) {
    	UserDto userDto = userService.findByUsername(username);
        return coverDto2Vo(userDto);
    }

    @PostMapping("/del/{username}")
    public int del(@PathVariable String username) {
        return userService.removeByUsername(username);
    }

    @PostMapping("/save")
    public boolean save(@RequestBody User user) {
       return userService.save(user);
    }

    @PostMapping("/update")
    public boolean update(@RequestBody User user) {
        return userService.updateById(user);
    }

    private UserVo coverDto2Vo(UserDto userDto) {
    	if(userDto != null) {
    		UserVo userVo = new UserVo();
        	BeanCopyUtil.copyProperties(userDto, userVo);
        	return userVo;
    	}
    	return null;
    }
    
    
}
