package com.jeomo.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 角色-菜单对照表
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */

@TableName("sys_role_menu")
public class RoleMenu extends SysBaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    private String roleCode;

    /**
     * 菜单ID
     */
    private Integer menuCode;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Integer getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(Integer menuCode) {
        this.menuCode = menuCode;
    }
}
