package com.jeomo.mem.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
    private String memberId;

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
    private Integer status;

    /**
     * 版本号
     */
    private Long version;

}
