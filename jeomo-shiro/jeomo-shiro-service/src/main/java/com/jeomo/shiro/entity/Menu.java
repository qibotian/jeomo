package com.jeomo.shiro.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

/**
 * <p>
 * 菜单
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
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

    public Menu() {
        super();
    }

    public Menu(String code, String label, String path, String parentCode, int sort, List<Menu> children) {
        super();
        this.code = code;
        this.label = label;
        this.path = path;
        this.parentCode = parentCode;
        this.sort = sort;
        this.children = children;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}
