package com.jeomo.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jeomo.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

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
public class Menu extends BaseEntity {

    private static final long serialVersionUID = 1L;

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
    private Long parentId;

    /**
     * 子菜单
     */
    private List<Menu> children;

    /**
     * 排序
     */
    private int sort;


}
