package com.jeomo.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jeomo.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色-菜单对照表
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_role_menu")
public class RoleMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 菜单ID
     */
    private Integer menuId;


}
