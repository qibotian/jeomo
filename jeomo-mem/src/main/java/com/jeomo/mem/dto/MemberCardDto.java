package com.jeomo.mem.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Author: qbt
 * @Date: 2020/5/8 20:17
 * @Version 1.0
 */
@Data
public class MemberCardDto {
    /**
     * 会员基本信息Id
     */
    private Long memberId;

    /**
     * 会员卡号
     */
    private Long cardNo;

    /**
     * 会员级别
     */
    private Long level;

    /**
     * 开卡商场
     */
    private Long openMallId;

    /**
     * 开卡时间
     */
    private Date openTime;

    /**
     * 身份最后检查时间
     */
    private Date lastCheckTime;
}
