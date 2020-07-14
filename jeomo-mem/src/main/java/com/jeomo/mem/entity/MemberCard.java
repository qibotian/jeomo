package com.jeomo.mem.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jeomo.common.entity.BaseEntity;
import com.jeomo.mem.enums.MemberCardStatusEnums;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
@EqualsAndHashCode(callSuper=false)
public class MemberCard extends BaseEntity {

    /**  */
	private static final long serialVersionUID = 1L;

	/**
     * 会员基本信息Id
     */
    private String memberCode;
    
    /**
     * 组织ID
     */
    private String orgCode;
    
    /**
     * 同城ID
     */
    private String mallGroupCode;

    /**
     * 会员卡号
     */
    private String code;
    
    /**
     * 开卡商场
     */
    private String openMallCode;
    
    /**
     * 开卡时间
     */
    private Date openTime;

    /**
     * 会员级别
     */
    private Long level;

    /**
     * 身份最后检查时间
     */
    private Date lastCheckTime;

    /**
     * 当前状态
     */
    private MemberCardStatusEnums status;

    @TableField(exist = false)
    private String name;

    @TableField(exist = false)
    private String phone;

    @TableField(exist = false)
    private Integer sex;
    
    @TableField(exist = false)
    private Date birthday;

    @TableField(exist = false)
    private String address;

    /**
     * 版本号
     */
    private Long version;

}
