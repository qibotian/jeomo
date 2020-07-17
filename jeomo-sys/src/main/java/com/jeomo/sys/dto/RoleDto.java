package com.jeomo.sys.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统角色
 * 角色应是组织分离的
 * 即每个组织都有自己的角色体系
 * </p>
 * @author jeomo
 * @since 2019-03-22
 */
@Data
@Accessors(chain = true)
@TableName("sys_role")
public class RoleDto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * 组织码
     */
    private String orgCode;

    /**
     * 角色代码
     * 默认生成规则为 组织码+序列号
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
    private List<MenuDto> menus = new ArrayList<>();

}
