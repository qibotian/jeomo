package com.jeomo.mem.log;

import com.jeomo.mem.enums.MemberLogTypeEnum;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * 会员日志
 * @Author: qbt
 * @Date: 2020/2/28 11:49
 * @Version 1.0
 */
@Data
@Builder
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

}
