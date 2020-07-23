package com.jeomo.sys.vo;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableName;


/**
 * <p>
 * 菜单
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
@TableName("sys_menu")
public class MenuVo implements Serializable {

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
    private List<MenuVo> children;

    /**
     * 排序
     */
    private int sort;

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

    public List<MenuVo> getChildren() {
        return children;
    }

    public void setChildren(List<MenuVo> children) {
        this.children = children;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
