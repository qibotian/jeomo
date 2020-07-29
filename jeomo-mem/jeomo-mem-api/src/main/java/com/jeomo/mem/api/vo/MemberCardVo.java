package com.jeomo.mem.api.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeomo.mem.api.enums.MemberCardStatusEnums;

/**
 * @Author: qbt
 * @Date: 2020/5/8 20:19
 * @Version 1.0
 */
public class MemberCardVo implements Serializable {

    /**  */
	private static final long serialVersionUID = 1L;

	/**
     * 会员基本信息Id
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    private String memberId;

    /**
     * 会员卡号
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    private String cardNo;

    /**
     * 会员级别
     */
    private Integer level;

    private String name;

    private String phone;

    private Integer sex;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date openTime;

    /**
     * 身份最后检查时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastCheckTime;

    /**
     * 当前状态
     */
    private MemberCardStatusEnums status;


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

    public Integer getMallGroupId() {
        return mallGroupId;
    }

    public void setMallGroupId(Integer mallGroupId) {
        this.mallGroupId = mallGroupId;
    }

    public Integer getOpenMallId() {
        return openMallId;
    }

    public void setOpenMallId(Integer openMallId) {
        this.openMallId = openMallId;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
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
}
