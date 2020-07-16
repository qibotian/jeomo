package com.jeomo.mem.service;

import com.jeomo.common.service.IBaseService;
import com.jeomo.mem.dto.MemberCardDto;
import com.jeomo.mem.dto.MemberRegisterDto;
import com.jeomo.mem.entity.MemberCard;
import com.jeomo.mem.query.QueryMemberCardByMemberCodeAndMallGroupCode;

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
	MemberCardDto openCard(MemberRegisterDto registerDto);
	
	/**
	 * <p>方法名称：根据会员号 和门店号查询会员卡信息</p>
	 * <p>方法说明：根据会员号 和门店号查询会员卡信息</p>
	 * @param queryMemberCardByMemberCodeAndMallCode
	 * @return
	 * @author qibotian
	 * @time 2020年7月16日 下午3:34:10
	 */
	MemberCard selectByMemberCodeAndMallCode(QueryMemberCardByMemberCodeAndMallGroupCode queryMemberCardByMemberCodeAndMallCode);
	
	/**
	 * 
	 * <p>方法名称：根据会员卡号查询会员信息</p>
	 * <p>方法说明：根据会员卡号查询会员信息</p>
	 * @param code
	 * @return
	 * @author qibotian
	 * @time 2020年7月16日 下午5:30:28
	 */
	MemberCardDto queryByCode(String code);

}
