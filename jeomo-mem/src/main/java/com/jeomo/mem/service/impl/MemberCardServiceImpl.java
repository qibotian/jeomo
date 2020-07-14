package com.jeomo.mem.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeomo.common.service.impl.BaseServiceImpl;
import com.jeomo.common.util.StringUtils;
import com.jeomo.masterdata.dto.MallDto;
import com.jeomo.mem.entity.MemberCard;
import com.jeomo.mem.enums.MemberCardStatusEnums;
import com.jeomo.mem.mapper.MemberCardMapper;
import com.jeomo.mem.service.IMemberCardService;
import com.jeomo.mem.service.IMemberLevelService;

/**
 * @Author: qbt
 * @Date: 2020/6/30 15:27
 * @Version 1.0
 */
@Service
@Transactional
public class MemberCardServiceImpl extends BaseServiceImpl<MemberCardMapper, MemberCard> implements IMemberCardService, BeanPostProcessor {

    @Autowired
    private IMemberLevelService memberLevelService;

    /**
     * 新的卡号，
     * 同一个购物中心族群下使用一个卡号和同一个会员级别
     * @param groupId
     * @return
     */
    private String newCardNo(String groupCode) {
    	String maxCode = baseMapper.queryMallGroupMaxCadeCode(groupCode);
    	int serialNo = 0;
    	if(!StringUtils.isEmpty(maxCode)) {
    		serialNo = Integer.valueOf(maxCode.substring(groupCode.length() + 1)) + 1;
    	}
    	return groupCode + StringUtils.headerAppend(String.valueOf(serialNo), '0', 8);
    }

    /**
     * 新开卡
     * @param memberId
     * @param openMall
     * @param openTime
     * @return
     */
    public MemberCard openCard(String memberId, MallDto openMall, Date openTime) {
        MemberCard card = new MemberCard();
        card.setOrgCode(openMall.getOrgCode());
        card.setMallGroupCode(openMall.getGroupCode());
        card.setCode(newCardNo(openMall.getGroupCode())); //生成会员卡号
        card.setMemberCode(memberId);
        card.setLevel(memberLevelService.queryDefaultMemberLevel()); //设置会员级别
        card.setOpenTime(openTime);
        card.setOpenMallCode(openMall.getCode());
        card.setLastCheckTime(openTime);
        card.setStatus(MemberCardStatusEnums.NORMAL);
        baseMapper.insert(card);
        return card;
    }

}
