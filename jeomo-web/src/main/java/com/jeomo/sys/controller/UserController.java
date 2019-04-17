package com.jeomo.sys.controller;

import com.jeomo.common.controller.BaseController;
import com.jeomo.common.vo.DataTable;
import com.jeomo.sys.entity.User;
import com.jeomo.sys.service.IUserService;
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
@RequestMapping("/sys/user")
public class UserController extends BaseController {

    @Autowired
    IUserService userService;

    @RequestMapping("/{id}")
    public User get(@PathVariable Long id) {
        return userService.getById(id);
    }

    @RequestMapping("")
    public String list() {
        return "sys/user/list";
    }

    @RequestMapping("/list")
    public DataTable<User> list(@RequestBody DataTable dt) {
        return userService.pageSearch(dt);
    }

    @RequestMapping("/del/{id}")
    public boolean del(@PathVariable Long id) {
        return userService.removeById(id);
    }


}
