package com.jeomo.mem.dto;

import com.jeomo.mem.enums.MemberRegisterTypeEnum;
import lombok.Getter;

/**
 * @Author: qbt
 * @Date: 2020/5/8 16:02
 * @Version 1.0
 */
public class MemberRegisterDto {

    /**
     * 姓名
     */
    @Getter
    private String name;

    /**
     * 手机号
     */
    @Getter
    private String phone;

    /**
     * 注册的商场Id
     */
    @Getter
    private Integer mallId;

    /**
     * 注册类型
     */
    @Getter
    private MemberRegisterTypeEnum registerType;


}
