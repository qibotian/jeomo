package com.jeomo.mem.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jeomo.common.service.impl.BaseServiceImpl;
import com.jeomo.mem.entity.Member;
import com.jeomo.mem.mapper.MemberMapper;
import com.jeomo.mem.service.IMemberService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */

@Service(version = "${mem.service.version}")
@Path("mem")
public class MemberServiceImpl extends BaseServiceImpl<MemberMapper, Member> implements IMemberService {

    @Override
    @Path("hi")
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public String sayHi() {
        System.out.println("hi member");
        return "hi member, you get it!";
    }

    @Override
    public Member testGetById(Long id) {
        Member member = new Member();
        member.setName("test");
        member.setId(id);
        return member;
    }
}
