package com.jeomo.mem.service;

import com.jeomo.common.service.IBaseService;
import com.jeomo.masterdata.dto.MallDto;
import com.jeomo.mem.entity.MemberCard;

import java.util.Date;

/**
 * @Author: qbt
 * @Date: 2020/6/30 15:27
 * @Version 1.0
 */
public interface IMemberCardService extends IBaseService<MemberCard> {

    /**
     * 开卡
     * @param memberId
     * @param openMall
     * @param openTime
     * @return
     */
    MemberCard newMemberCard(String memberId, MallDto openMall, Date openTime);

}
