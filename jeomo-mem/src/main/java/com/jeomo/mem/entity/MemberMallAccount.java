package com.jeomo.mem.entity;

import com.jeomo.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员账户信息
 * @Author: qbt
 * @Date: 2020/3/1 0:53
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberMallAccount extends BaseEntity {

    /**
     * 会员卡Id
     */
    private long memberCardId;

    /**
     * 商场信息
     */
    private long mallId;

    /**
     * 积分信息
     */
    private Integer point;

    /**
     * 累计消费金额(元)
     */
    private BigDecimal totalConsumeAmount;

    /**
     * 累计积分
     */
    private Integer totalPoint;

    /**
     * 最近一次消费时间
     */
    private Date lastConsumeTime;

    /**
     * 状态
     */
    private Integer status;

}
