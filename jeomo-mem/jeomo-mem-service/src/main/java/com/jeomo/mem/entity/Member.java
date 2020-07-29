package com.jeomo.mem.entity;

import com.jeomo.common.entity.BaseEntity;
import com.jeomo.common.result.enums.SexEnum;
import com.jeomo.mem.api.enums.MemberRegisterTypeEnum;

import java.util.Date;

/**
 * <p>
 * 会员基本信息表
 * </p>
 * @author jeomo
 * @since 2019-03-22
 */
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public MemberRegisterTypeEnum getRegisterType() {
        return registerType;
    }

    public void setRegisterType(MemberRegisterTypeEnum registerType) {
        this.registerType = registerType;
    }

    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public String getLastAccessMallCode() {
        return lastAccessMallCode;
    }

    public void setLastAccessMallCode(String lastAccessMallCode) {
        this.lastAccessMallCode = lastAccessMallCode;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public String getFirstOpenMallCode() {
        return firstOpenMallCode;
    }

    public void setFirstOpenMallCode(String firstOpenMallCode) {
        this.firstOpenMallCode = firstOpenMallCode;
    }
}
