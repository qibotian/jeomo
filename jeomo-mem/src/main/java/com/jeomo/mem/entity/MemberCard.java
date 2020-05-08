package com.jeomo.mem.entity;

import com.jeomo.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 会员卡信息
 * @Author: qbt
 * @Date: 2020/3/1 0:48
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MemberCard extends BaseEntity {

    /**
     * 会员基本信息Id
     */
    private Long memberId;

    /**
     * 同城ID
     */
    private Integer mallGroupId;

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
    private Integer openMallId;

    /**
     * 开卡时间
     */
    private Date openTime;

    /**
     * 身份最后检查时间
     */
    private Date lastCheckTime;



}
