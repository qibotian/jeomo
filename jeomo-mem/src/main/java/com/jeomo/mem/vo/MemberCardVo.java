package com.jeomo.mem.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @Author: qbt
 * @Date: 2020/5/8 20:19
 * @Version 1.0
 */
@Data
public class MemberCardVo {

    /**
     * 会员基本信息Id
     */
    private Long memberId;

    /**
     * 会员卡号
     */
    private Long cardNo;

    /**
     * 会员级别
     */
    private Long level;

    /**
     * 开卡商场
     */
    private Long openMallId;

    /**
     * 开卡时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date openTime;

}
