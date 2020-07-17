package com.jeomo.mem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.jeomo.common.service.impl.BaseServiceImpl;
import com.jeomo.common.util.BeanCopyUtil;
import com.jeomo.common.util.StringUtils;
import com.jeomo.masterdata.dto.MallDto;
import com.jeomo.masterdata.service.IMallService;
import com.jeomo.mem.dto.MemberDto;
import com.jeomo.mem.entity.Member;
import com.jeomo.mem.intf.dto.MemberRegisterDto;
import com.jeomo.mem.mapper.MemberMapper;
import com.jeomo.mem.query.QueryMemberByOrgCodeAndPhone;
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
    private IMallService mallService;
	
    /**
     * 默认的注册会员
     * @param registerDto
     * @param openTime
     * @return
     */
    public MemberDto memberRegister(MemberRegisterDto memberRegisterDto) {
    	MallDto mallDto = mallService.queryMallByCode(memberRegisterDto.getMallCode());
    	QueryMemberByOrgCodeAndPhone queryMemberByOrgCodeAndPhone = new QueryMemberByOrgCodeAndPhone(mallDto.getOrgCode(), memberRegisterDto.getPhone());
		Member member = this.baseMapper.queryMemberByOrgCodeAndPhone(queryMemberByOrgCodeAndPhone );
		if(member == null) {
			member = new Member();
	        member.setId(IdWorker.getId());
	        member.setOrgCode(mallDto.getOrgCode());
	        member.setFirstOpenMallCode(memberRegisterDto.getMallCode()); //注册门店
	        member.setOpenTime(memberRegisterDto.getOpenTime()); //注册时间
	        member.setLastAccessMallCode(memberRegisterDto.getMallCode()); //最近访问门店
	        member.setLastAccessTime(memberRegisterDto.getOpenTime()); //最近访问时间
	        member.setRegisterType(memberRegisterDto.getRegisterType()); //注册类型
	        member.setName(memberRegisterDto.getName());
	        member.setPhone(memberRegisterDto.getPhone());
	        member.setCode(newMemberCode(mallDto.getOrgCode())); //设置注册码
	        this.baseMapper.saveMemberIfAbsent(member);
		}
        MemberDto dto = new MemberDto();
        BeanCopyUtil.copyProperties(member, dto);
        return dto;
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
