package com.jeomo.mem.dto;

import java.util.Date;

import com.jeomo.mem.enums.MemberCardStatusEnums;

import lombok.Data;

/**
 * @Author: qbt
 * @Date: 2020/5/8 20:17
 * @Version 1.0
 */
@Data
public class MemberCardDto {
	
	/**
	 * 组织ID
	 */
	private Long id;
	
	/**
	 * 组织ID
	 */
	private Long orgId;

	/**
	 * 会员ID
	 */
    private Long memberId;

    /**
	 * 会员名称
	 */
    private String name;

    /**
	 * 会员手机号码
	 */
    private String phone;

    /**
	 * 会员性别
	 */
    private Integer sex;

    /**
	 * 会员生日
	 */
    private Date birthday;

    /**
	 * 会员地址
	 */
    private String address;

    /**
     * 同城ID
     */
    private Long mallGroupId;

    /**
     * 开卡商场
     */
    private Long openMallId;

    /**
     * 开卡时间
     */
    private Date openTime;

    /**
     * 会员卡号
     */
    private String cardNo;

    /**
     * 会员级别
     */
    private Integer level;

    /**
     * 身份最后检查时间
     */
    private Date lastCheckTime;

    /**
     * 当前状态
     */
    private MemberCardStatusEnums status;

}
