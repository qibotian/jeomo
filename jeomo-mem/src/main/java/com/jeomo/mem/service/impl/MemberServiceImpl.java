package com.jeomo.mem.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeomo.common.service.impl.BaseServiceImpl;
import com.jeomo.common.util.StringUtils;
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
        MallDto mallDto = mallService.queryMallByCode(registerDto.getMallCode());
        Date openTime = new Date();
        Member member = newMember(registerDto, openTime);
        MemberCard memberCard = memberCardService.openCard(member.getCode(), mallDto, openTime);
        MemberCardDto dto = new MemberCardDto();
        BeanUtils.copyProperties(memberCard, dto);
        return dto;
    }

    /**
     * 新增会员
     * @param registerDto
     * @param openTime
     * @return
     */
    private Member newMember(MemberRegisterDto registerDto, Date openTime) {
        MallDto mallDto = mallService.queryMallByCode(registerDto.getMallCode());
        Member member = new Member();
        //设置会员注册时间
        member.setOrgCode(mallDto.getOrgCode());
        member.setOpenTime(openTime);
        member.setName(registerDto.getName());
        member.setCode(newMemberCode(mallDto.getOrgCode()));
        member.setPhone(registerDto.getPhone());
        member.setFirstOpenMallCode(registerDto.getMallCode());
        member.setLastAccessTime(openTime);
        member.setLastAccessMallCode(registerDto.getMallCode());
        this.baseMapper.insert(member);
        return member;
    }
    
    /**
     * <p>方法名称：生成新的会员code</p>
     * <p>方法说明：会员CODE由组织号+8位流水号组成， 8位流水号最多可以注册一个亿的会员，完全够一个组织的会员使用</p>
     * @param orgCode
     * @return
     * @author qibotian
     * @time 2020年7月13日 下午4:16:18
     */
    private synchronized String newMemberCode(String orgCode) {
    	String maxCode = baseMapper.queryMaxMemberCode(orgCode);
    	int serialNo = 0;
    	if(!StringUtils.isEmpty(maxCode)) {
    		serialNo = Integer.valueOf(maxCode.substring(orgCode.length() + 1)) + 1;
    	}
    	return orgCode + StringUtils.headerAppend(String.valueOf(serialNo), '0', 8);
    }

}
