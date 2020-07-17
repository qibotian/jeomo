package com.jeomo.sys.entity;

import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_menu")
public class Menu extends SysBaseEntity {

    private static final long serialVersionUID = 1L;
    
    /**
     * 菜单编号
     */
    private String code;

    /**
     * 菜单名称
     */
    private String label;

    /**
     * 菜单路径
     */
    private String path;

    /**
     * 父ID
     */
    private String parentCode;

    /**
     * 排序
     */
    private int sort;
    
    /**
     * 子菜单
     */
    @TableField(exist=false)
    private List<Menu> children;
    
}
