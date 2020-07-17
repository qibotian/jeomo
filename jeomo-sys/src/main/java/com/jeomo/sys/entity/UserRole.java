package com.jeomo.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户-角色关系表
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
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
    
}
