package com.jeomo.mem.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jeomo.common.entity.BaseEntity;
import com.jeomo.mem.enums.MemberCardStatusEnums;

import java.util.Date;

/**
 * 会员卡信息
 * @Author: qbt
 * @Date: 2020/3/1 0:48
 * @Version 1.0
 */
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

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getMallGroupCode() {
        return mallGroupCode;
    }

    public void setMallGroupCode(String mallGroupCode) {
        this.mallGroupCode = mallGroupCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOpenMallCode() {
        return openMallCode;
    }

    public void setOpenMallCode(String openMallCode) {
        this.openMallCode = openMallCode;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Date getLastCheckTime() {
        return lastCheckTime;
    }

    public void setLastCheckTime(Date lastCheckTime) {
        this.lastCheckTime = lastCheckTime;
    }

    public MemberCardStatusEnums getStatus() {
        return status;
    }

    public void setStatus(MemberCardStatusEnums status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
