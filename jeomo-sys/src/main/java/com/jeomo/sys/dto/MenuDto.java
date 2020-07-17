package com.jeomo.sys.dto;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
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
@Accessors(chain = true)
@TableName("sys_menu")
public class MenuDto implements Serializable {

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
     * 子菜单
     */
    private List<MenuDto> children;

    /**
     * 排序
     */
    private int sort;
    
}
