package com.jeomo.mem.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.jeomo.common.mapper.IBaseMapper;
import com.jeomo.mem.entity.Member;
import com.jeomo.mem.query.QueryMemberByOrgCodeAndPhone;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
@Mapper
public interface MemberMapper extends IBaseMapper<Member> {


	String queryMaxMemberCode(String orgCode);
	
	/**
	 * <p>方法说明：根据组织号和手机号查询会员信息</p>
	 * @return
	 * @author qibotian
	 * @time 2020年7月16日 下午3:56:49
	 */
	Member selectByOrgCodeAndPhoneNumber();


	/**
	 * <p>方法名称： 如果会员库中没有，则新增会员，有的话不做改动</p>
	 * <p>方法说明：如果会员库中没有，则新增会员此时返回 1,，有的话不做改动，此时返回0</p>
	 * @param member
	 * @return
	 * @author qibotian
	 * @time 2020年7月16日 下午2:12:52
	 */
	int saveMemberIfAbsent(Member member);
	
	/**
	 * <p>方法名称：根据手机号和组织号查询会员信息</p>
	 * <p>方法说明：根据手机号和组织号查询会员信息</p>
	 * @param queryMemberByOrgCodeAndPhone
	 * @return
	 * @author qibotian
	 * @time 2020年7月16日 下午4:08:50
	 */
	Member queryMemberByOrgCodeAndPhone(QueryMemberByOrgCodeAndPhone queryMemberByOrgCodeAndPhone);



}
