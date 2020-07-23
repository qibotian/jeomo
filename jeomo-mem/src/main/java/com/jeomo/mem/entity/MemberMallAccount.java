package com.jeomo.mem.entity;

import com.jeomo.common.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员账户信息
 * @Author: qbt
 * @Date: 2020/3/1 0:53
 * @Version 1.0
 */
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


    public long getMemberCardId() {
        return memberCardId;
    }

    public void setMemberCardId(long memberCardId) {
        this.memberCardId = memberCardId;
    }

    public long getMallId() {
        return mallId;
    }

    public void setMallId(long mallId) {
        this.mallId = mallId;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public BigDecimal getTotalConsumeAmount() {
        return totalConsumeAmount;
    }

    public void setTotalConsumeAmount(BigDecimal totalConsumeAmount) {
        this.totalConsumeAmount = totalConsumeAmount;
    }

    public Integer getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(Integer totalPoint) {
        this.totalPoint = totalPoint;
    }

    public Date getLastConsumeTime() {
        return lastConsumeTime;
    }

    public void setLastConsumeTime(Date lastConsumeTime) {
        this.lastConsumeTime = lastConsumeTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
