package com.jeomo.sys.controller;

import com.jeomo.common.controller.BaseController;
import com.jeomo.common.result.annotation.ResponseResult;
import com.jeomo.sys.entity.Menu;
import com.jeomo.sys.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜单 前端控制器
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
@RestController
@ResponseResult
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
    public List<Menu> list() {
        return menuService.list();
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

    @PostMapping("/selectLikeByLabel")
    public  List<Menu> selectLikeByLabel(@RequestBody String label) {
        return menuService.selectLikeByLabel(label);
    }

}
