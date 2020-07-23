package com.jeomo.mem.entity;

import com.jeomo.common.entity.BaseEntity;

import java.util.Date;

/**
 * @Author: qbt
 * @Date: 2020/2/27 23:00
 * @Version 1.0
 */
public class MemberPointDetail extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
     * 业务类型
     * 1 普通消费
     * 2 消费退货
     * 3 手工调整
     * 4 注册送积分
     * 5 其他
     */
    private Integer businessType;

    /**
     * 业务时间
     */
    private Date businessTime;

    /**
     * 消费和退货时为订单ID
     * 业务Id
     */
    private Long businessId;

    /**
     * 积分
     */
    private Integer point;

    /**
     * 备注
     */
    private String memo;

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public Date getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(Date businessTime) {
        this.businessTime = businessTime;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
