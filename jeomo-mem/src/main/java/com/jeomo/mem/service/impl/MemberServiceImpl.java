package com.jeomo.mem.service.impl;

import com.jeomo.common.service.impl.BaseServiceImpl;
import com.jeomo.masterdata.dto.MallDto;
import com.jeomo.masterdata.service.IMallService;
import com.jeomo.mem.dto.MemberCardDto;
import com.jeomo.mem.dto.MemberRegisterDto;
import com.jeomo.mem.entity.Member;
import com.jeomo.mem.entity.MemberCard;
import com.jeomo.mem.factory.MemberCardFactory;
import com.jeomo.mem.mapper.MemberCardMapper;
import com.jeomo.mem.mapper.MemberMapper;
import com.jeomo.mem.service.IMemberLevelService;
import com.jeomo.mem.service.IMemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */

@Service
@Transactional
public class MemberServiceImpl extends BaseServiceImpl<MemberMapper, Member> implements IMemberService {

    @Autowired
    private MemberCardMapper memberCardMapper;

    @Autowired
    private IMemberLevelService memberLevelService;

    @Autowired
    private IMallService mallService;

    @Override
    public MemberCardDto register(MemberRegisterDto registerDto) {
        MallDto mallDto = mallService.queryMallByMallId(registerDto.getMallId());
        Date openTime = new Date();
        Long memberId = newMember(registerDto, openTime);
        MemberCard memberCard = newMemberCard(memberId, mallDto, openTime);
        MemberCardDto dto = new MemberCardDto();
        BeanUtils.copyProperties(memberCard, dto);
        return dto;
    }



    private Long newMember(MemberRegisterDto registerDto, Date openTime) {
        Member member = new Member();
        BeanUtils.copyProperties(registerDto, member);
        member.setMemberId(MemberCardFactory.createMemberCard());
        //设置会员注册时间
        member.setOpenTime(openTime);
        member.setFirstOpenMallId(registerDto.getMallId());
        this.baseMapper.insert(member);
        return member.getMemberId();
    }

    private MemberCard newMemberCard(Long memberId, MallDto openMall, Date openTime) {
        MemberCard card = new MemberCard();
        card.setMallGroupId(openMall.getGroupId());
        card.setCardNo(MemberCardFactory.createMemberCard()); //生成会员卡号
        card.setLevel(memberLevelService.queryDefaultMemberLevel()); //设置会员级别
        card.setLastCheckTime(openTime);
        card.setOpenTime(openTime);
        card.setMemberId(memberId);
        card.setOpenMallId(openMall.getMallId());
        memberCardMapper.insert(card);
        return card;
    }
}
