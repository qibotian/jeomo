package com.jeomo.mem.service;

import com.jeomo.common.service.IBaseService;
import com.jeomo.mem.dto.MemberCardDto;
import com.jeomo.mem.dto.MemberRegisterDto;
import com.jeomo.mem.entity.Member;

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
     * 会员注册方法
     * @return 会员卡号
     */
    MemberCardDto register(MemberRegisterDto dto);


}
