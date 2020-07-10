package com.jeomo.sys.controller;

import com.jeomo.common.controller.BaseController;
import com.jeomo.common.vo.DataTable;
import com.jeomo.sys.entity.Role;
import com.jeomo.sys.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
@RestController
@RequestMapping("/sys/role")
public class RoleController extends BaseController {

    @Autowired
    protected  IRoleService roleService;

    @PostMapping("/{id}")
    public Role get(@PathVariable Long id) {
        return roleService.getById(id);
    }

    @PostMapping("/detail/{id}")
    public Role detail(@PathVariable Long id) {
        return roleService.getById(id);
    }

    @PostMapping("/list")
    public DataTable<Role> list(@RequestBody DataTable dt) {
        return roleService.pageSearch(dt);
    }

    @PostMapping("/del/{id}")
    public boolean del(@PathVariable Long id) {
        return roleService.removeById(id);
    }

    @PostMapping("/create")
    public boolean create(@RequestBody Role role) {
        return roleService.save(role);
    }

    @PostMapping("/update")
    public boolean update(@RequestBody Role role) {
        return roleService.updateById(role);
    }


}
