package com.jeomo.mem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jeomo.common.mapper.IBaseMapper;
import com.jeomo.mem.dto.MallGroupMaxCardCodeDto;
import com.jeomo.mem.entity.MemberCard;
import com.jeomo.mem.query.QueryMemberCardByMemberCodeAndMallGroupCode;

/**
 * <p>
 * 会员卡表 Mapper 接口
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
@Mapper
public interface MemberCardMapper extends IBaseMapper<MemberCard> {
	
	List<MallGroupMaxCardCodeDto> selectMaxCardNo();
	
	String queryMallGroupMaxCadeCode(String groupCode);
	
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
	MemberCard queryByCode(String code);
	
}
