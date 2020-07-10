package com.jeomo.mem.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeomo.mem.enums.MemberCardStatusEnums;

import lombok.Data;

import java.util.Date;

/**
 * @Author: qbt
 * @Date: 2020/5/8 20:19
 * @Version 1.0
 */
@Data
public class MemberCardVo {

    /**
     * 会员基本信息Id
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    private String memberId;

    /**
     * 会员卡号
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    private String cardNo;

    /**
     * 会员级别
     */
    private Integer level;

    private String name;

    private String phone;

    private Integer sex;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    private String address;

    /**
     * 同城ID
     */
    private Integer mallGroupId;

    /**
     * 开卡商场
     */
    private Integer openMallId;

    /**
     * 开卡时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date openTime;

    /**
     * 身份最后检查时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastCheckTime;

    /**
     * 当前状态
     */
    private MemberCardStatusEnums status;
}
