package com.jeomo.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    /**
     * @return
     */
    @RequestMapping("/{id}")
    @RequiresPermissions("resource:query")
    public String resource(@PathVariable(name = "id") String id) {
        return "O(∩_∩)O哈哈~， 获取资源: " + id;
    }

    /**
     * @return
     */
    @RequestMapping("/update/{id}")
    @RequiresPermissions("resource:update")
    public String resourceUpdate(@PathVariable(name = "id") String id) {
        return "O(∩_∩)O哈哈~， 获取资源: " + id;
    }
}
