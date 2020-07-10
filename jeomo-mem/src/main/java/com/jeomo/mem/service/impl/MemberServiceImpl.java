package com.jeomo.mem.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeomo.common.service.impl.BaseServiceImpl;
import com.jeomo.masterdata.dto.MallDto;
import com.jeomo.masterdata.service.IMallService;
import com.jeomo.mem.dto.MemberCardDto;
import com.jeomo.mem.dto.MemberRegisterDto;
import com.jeomo.mem.entity.Member;
import com.jeomo.mem.entity.MemberCard;
import com.jeomo.mem.mapper.MemberMapper;
import com.jeomo.mem.service.IMemberCardService;
import com.jeomo.mem.service.IMemberService;

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
    private IMemberCardService memberCardService;

    @Autowired
    private IMallService mallService;

    @Override
    public MemberCardDto register(MemberRegisterDto registerDto) {
        MallDto mallDto = mallService.queryMallByMallId(registerDto.getMallId());
        Date openTime = new Date();
        Member member = newMember(registerDto, openTime);
        MemberCard memberCard = memberCardService.openCard(member.getId(), mallDto, openTime);
        MemberCardDto dto = new MemberCardDto();
        BeanUtils.copyProperties(memberCard, dto);
        return dto;
    }

    /**
     * 新的会员
     * @param registerDto
     * @param openTime
     * @return
     */
    private Member newMember(MemberRegisterDto registerDto, Date openTime) {
        MallDto mallDto = mallService.queryMallByMallId(registerDto.getMallId());
        Member member = new Member();
        BeanUtils.copyProperties(registerDto, member);
        //设置会员注册时间
        member.setOpenTime(openTime);
        member.setFirstOpenMallId(registerDto.getMallId());
        member.setOrgId(mallDto.getOrgId());
        this.baseMapper.insert(member);
        return member;
    }

}
