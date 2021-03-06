package com.jeomo.shiro.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 系统角色
 * 角色应是组织分离的
 * 即每个组织都有自己的角色体系
 * </p>
 * @author jeomo
 * @since 2019-03-22
 */
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
    private List<MenuDto> menus = new ArrayList<>();

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuDto> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuDto> menus) {
        this.menus = menus;
    }
}
