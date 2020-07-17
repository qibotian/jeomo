package com.jeomo.mem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeomo.common.service.impl.BaseServiceImpl;
import com.jeomo.common.util.BeanCopyUtil;
import com.jeomo.common.util.StringUtils;
import com.jeomo.masterdata.dto.MallDto;
import com.jeomo.masterdata.service.IMallService;
import com.jeomo.mem.dto.MemberDto;
import com.jeomo.mem.entity.MemberCard;
import com.jeomo.mem.enums.MemberCardStatusEnums;
import com.jeomo.mem.exceptions.PhoneHasRegisterExcetion;
import com.jeomo.mem.intf.dto.MemberCardDto;
import com.jeomo.mem.intf.dto.MemberRegisterDto;
import com.jeomo.mem.mapper.MemberCardMapper;
import com.jeomo.mem.query.QueryMemberCardByMemberCodeAndMallGroupCode;
import com.jeomo.mem.service.IMemberCardService;
import com.jeomo.mem.service.IMemberLevelService;
import com.jeomo.mem.service.IMemberService;

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
    
    @Autowired
    private IMemberService memberService;
    
    @Autowired
    private IMallService mallService;

    /**
     * 新开卡
     * @param memberId
     * @param openMall
     * @param openTime
     * @return
     */
    public MemberCardDto openCard(MemberRegisterDto registerDto) {
    	MallDto mallDto = mallService.queryMallByCode(registerDto.getMallCode());
        MemberDto member = memberService.memberRegister(registerDto);
        //首先查找该会员是否已经在本店开过卡
        QueryMemberCardByMemberCodeAndMallGroupCode queryMemberCardByMemberCodeAndMallCode = new QueryMemberCardByMemberCodeAndMallGroupCode(member.getCode(), mallDto.getGroupCode());
		MemberCard card = baseMapper.selectByMemberCodeAndMallCode(queryMemberCardByMemberCodeAndMallCode);
        if(card != null) {
        	throw new PhoneHasRegisterExcetion();
        }
        card = new MemberCard();
        card.setOrgCode(mallDto.getOrgCode());
        card.setMallGroupCode(mallDto.getGroupCode());
        card.setCode(newCardNo(mallDto.getGroupCode())); //生成会员卡号
        card.setMemberCode(member.getCode());
        card.setLevel(memberLevelService.queryDefaultMemberLevel()); //设置会员级别
        card.setOpenTime(registerDto.getOpenTime());
        card.setOpenMallCode(mallDto.getCode());
        card.setLastCheckTime(registerDto.getOpenTime());
        card.setStatus(MemberCardStatusEnums.NORMAL);
        baseMapper.insert(card);
        return coverMemberCard2Dto(card);
    }

	@Override
	public MemberCardDto selectByMemberCodeAndMallCode(QueryMemberCardByMemberCodeAndMallGroupCode queryMemberCardByMemberCodeAndMallCode) {
		return coverMemberCard2Dto(baseMapper.selectByMemberCodeAndMallCode(queryMemberCardByMemberCodeAndMallCode));
	}

	@Override
	public MemberCardDto queryByCode(String code) {
		MemberCard card = baseMapper.queryByCode(code);
	    return coverMemberCard2Dto(card);
	}

	private MemberCardDto coverMemberCard2Dto(MemberCard card) {
		if(card == null) {
			return null;
		}
		MemberCardDto dto = new MemberCardDto();
	    BeanCopyUtil.copyProperties(card, dto);
	    return dto;
	}
	
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
	
}
