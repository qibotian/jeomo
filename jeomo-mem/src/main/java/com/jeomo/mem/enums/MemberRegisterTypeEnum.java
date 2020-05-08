package com.jeomo.mem.enums;

/**
 * @Author: qbt
 * @Date: 2020/5/8 16:10
 * @Version 1.0
 */
public enum MemberRegisterTypeEnum {

    MEMBER_CENTER("会员中心注册", 1),
    MINI_PROGRAM("小程序注册", 2),
    OFFICIAL_ACCOUNT("公众号注册", 3),
    ;


    ;


    private String name;

    private int value;

    private MemberRegisterTypeEnum(String name, int value) {

    }
}

