package com.jeomo.mem.entity;

import java.util.Date;

import com.jeomo.common.entity.BaseEntity;
import com.jeomo.common.result.enums.SexEnum;
import com.jeomo.mem.intf.enums.MemberRegisterTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 会员基本信息表
 * </p>
 * @author jeomo
 * @since 2019-03-22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
public class Member extends BaseEntity {

    private static final long serialVersionUID = 1L;
    
    /**
     * 外表关联，则关联这个ID
     * 会员ID，逻辑主键
     * 一个组织中对一个人的唯一标识
     * 一个会员可以在多个MallGroup有不同的会员等级或身份
     */
    private String code;
    
    /**
     * 组织ID
     */
    private String orgCode;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 性别
     */
    private SexEnum sex;

    /**
     * 注册方式
     */
    private MemberRegisterTypeEnum registerType;
    
    
    /**
     * 最后访问时间
     */
    private Date lastAccessTime;
    
    /**
     * 最后访问门店
     */
    private String lastAccessMallCode;

    /**
     * 开卡时间
     */
    private Date openTime;
    
    /**
     * 首次开卡门店
     */
    private String firstOpenMallCode;

    


}
