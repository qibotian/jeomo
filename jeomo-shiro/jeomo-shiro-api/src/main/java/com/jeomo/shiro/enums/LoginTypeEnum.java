package com.jeomo.shiro.enums;

/**
 * 登录方式
 */
public enum LoginTypeEnum {

    /**
     * 管理平台登录
     * 主要针对于管理人员登录（包括业务人员）
     */
    MANAGE("MANAGE"),

    /**
     * 普通的用户登录
     * 主要针对于C端用户登录，比如会员等
     */
    NORMAL("NORMAL"),

    /**
     * 开放平台API登录
     */
    OPEN_API("OPEN_API");

    private String type;

    private LoginTypeEnum(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
