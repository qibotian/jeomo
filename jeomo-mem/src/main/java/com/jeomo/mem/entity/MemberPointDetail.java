package com.jeomo.mem.entity;

import java.util.Date;

import com.jeomo.common.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author: qbt
 * @Date: 2020/2/27 23:00
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
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



}
