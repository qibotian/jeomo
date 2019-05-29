package com.jeomo.sys.controller;

import com.jeomo.common.controller.BaseController;
import com.jeomo.common.vo.DataTable;
import com.jeomo.sys.entity.Menu;
import com.jeomo.sys.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 菜单 前端控制器
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
@RestController
@RequestMapping("/sys/menu")
public class MenuController extends BaseController {

    @Autowired
    protected IMenuService menuService;

    @PostMapping("/{id}")
    public Menu get(@PathVariable Long id) {
        return menuService.getById(id);
    }

    @PostMapping("/detail/{id}")
    public Menu detail(@PathVariable Long id) {
        return menuService.getById(id);
    }

    @PostMapping("/list")
    public DataTable<Menu> list(@RequestBody DataTable dt) {
        return menuService.pageSearch(dt);
    }

    @PostMapping("/del/{id}")
    public boolean del(@PathVariable Long id) {
        return menuService.removeById(id);
    }

    @PostMapping("/create")
    public boolean create(@RequestBody Menu menu) {
        return menuService.save(menu);
    }

    @PostMapping("/update")
    public boolean update(@RequestBody Menu menu) {
        return menuService.updateById(menu);
    }

}
