package com.jeomo.shiro.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 用户-角色关系表
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */

@TableName("sys_user_role")
public class UserRole extends SysBaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String username;

    /**
     * 角色ID
     */
    private String roleCode;


    public UserRole(String username, String roleCode) {
        this.username = username;
        this.roleCode = roleCode;
    }
}
