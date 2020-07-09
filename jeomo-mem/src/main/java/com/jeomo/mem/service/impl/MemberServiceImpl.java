package com.jeomo.mem.service.impl;

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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
    private IMemberCardService memberCardService;

    @Autowired
    private RedisTemplate<String, String> stringRedisTemplate;



    @Autowired
    private IMallService mallService;

    @Override
    public MemberCardDto register(MemberRegisterDto registerDto) {
        MallDto mallDto = mallService.queryMallByMallId(registerDto.getMallId());
        Date openTime = new Date();
        Member member = newMember(registerDto, openTime);
        MemberCard memberCard = memberCardService.newMemberCard(member.getMemberId(), mallDto, openTime);
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
        member.setMemberId(newMemberId(mallDto.getOrgId()));
        //设置会员注册时间
        member.setOpenTime(openTime);
        member.setFirstOpenMallId(registerDto.getMallId());
        this.baseMapper.insert(member);
        return member;
    }

    private String newMemberId(Integer orgId) {
        String key = "orgId:" + orgId + "memId";
        Long serialNo = stringRedisTemplate.opsForValue().increment(key);
        return String.valueOf(orgId) + String.valueOf(serialNo);
    }

}
