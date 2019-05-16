package com.jeomo.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jeomo.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_role")
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色代码
     */
    private String code;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色拥有的菜单
     */
    @TableField(exist = false)
    private List<Menu> menus = new ArrayList<>();

}
