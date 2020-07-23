package com.jeomo.mem.log;

import com.jeomo.mem.enums.MemberLogTypeEnum;

import java.util.Date;

/**
 * 会员日志
 * @Author: qbt
 * @Date: 2020/2/28 11:49
 * @Version 1.0
 */

public class MemberLog {

    /**
     * 会员Id
     */
    private Long memberId;

    /**
     * 日志类型
     */
    private MemberLogTypeEnum type;

    /**
     * 创建时间
     */
    private Date createTime = new Date();

    /**
     * 日志内容
     */
    private String message;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public MemberLogTypeEnum getType() {
        return type;
    }

    public void setType(MemberLogTypeEnum type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
