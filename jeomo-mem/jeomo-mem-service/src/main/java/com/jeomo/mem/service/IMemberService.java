package com.jeomo.mem.service;

import com.jeomo.common.service.IBaseService;
import com.jeomo.mem.dto.MemberDto;
import com.jeomo.mem.entity.Member;
import com.jeomo.mem.api.dto.MemberRegisterDto;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
public interface IMemberService extends IBaseService<Member> {

    /**
     * 
     * 保存会员基本信息
     * 以组织号和会员手机号为查询主键， 
     * 如果已经存在了相应的会员基本信息，
     * 则进行修改，如果不存在，则新增
     * @return 会员卡号
     */
	MemberDto memberRegister(MemberRegisterDto dto);
}
