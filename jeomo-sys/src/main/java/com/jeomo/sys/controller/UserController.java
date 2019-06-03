package com.jeomo.sys.controller;

import com.jeomo.common.controller.BaseController;
import com.jeomo.common.result.annotation.ResponseResult;
import com.jeomo.common.vo.DataTable;
import com.jeomo.sys.entity.User;
import com.jeomo.sys.service.IUserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数无效"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @PostMapping("/{id}")
    public User get(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping("/detail/{id}")
    public User detail(@PathVariable Long id) {
        return userService.findUserAllInfoById(id);
    }

    @PostMapping("/list")
    public DataTable<User> list(@RequestBody DataTable dt) {
        return userService.pageSearch(dt);
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
