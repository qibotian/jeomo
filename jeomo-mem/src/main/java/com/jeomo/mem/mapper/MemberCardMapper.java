package com.jeomo.mem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jeomo.common.mapper.IBaseMapper;
import com.jeomo.mem.dto.MallGroupMaxCardCodeDto;
import com.jeomo.mem.entity.MemberCard;

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

}
