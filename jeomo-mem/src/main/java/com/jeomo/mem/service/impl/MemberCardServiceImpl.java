package com.jeomo.mem.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeomo.common.service.impl.BaseServiceImpl;
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
    private RedisTemplate<String, String> stringRedisTemplate;

    @Autowired
    private IMemberLevelService memberLevelService;

    /**
     * 新的卡号，
     * 同一个购物中心族群下使用一个卡号和同一个会员级别
     * @param groupId
     * @return
     */
    private String newCardNo(Long groupId) {
        String key = "groupId:" + groupId + "cardNo";
        Long serialNo = stringRedisTemplate.opsForValue().increment(key);
        return String.valueOf(groupId) + String.valueOf(serialNo);
    }

    /**
     * 新开卡
     * @param memberId
     * @param openMall
     * @param openTime
     * @return
     */
    public MemberCard openCard(Long memberId, MallDto openMall, Date openTime) {
        MemberCard card = new MemberCard();
        card.setOrgId(openMall.getOrgId());
        card.setMallGroupId(openMall.getGroupId());
        card.setCardNo(newCardNo(openMall.getGroupId())); //生成会员卡号
        card.setLevel(memberLevelService.queryDefaultMemberLevel()); //设置会员级别
        card.setLastCheckTime(openTime);
        card.setOpenTime(openTime);
        card.setMemberId(memberId);
        card.setOpenMallId(openMall.getBaseId());
        card.setStatus(MemberCardStatusEnums.NORMAL);
        baseMapper.insert(card);
        return card;
    }

}
