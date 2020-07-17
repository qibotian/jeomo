package com.jeomo.mem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jeomo.common.dto.PageResponseDto;
import com.jeomo.common.query.PageQuery;
import com.jeomo.common.result.annotation.ResponseResult;
import com.jeomo.common.util.BeanCopyUtil;
import com.jeomo.common.vo.PageRequestVo;
import com.jeomo.common.vo.PageResponseVo;
import com.jeomo.mem.intf.dto.MemberCardDto;
import com.jeomo.mem.intf.dto.MemberRegisterDto;
import com.jeomo.mem.intf.vo.MemberCardVo;
import com.jeomo.mem.service.IMemberCardService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @Author: qbt
 * @Date: 2019/3/24 20:47
 * @Version 1.0
 */
@Controller
@RequestMapping("/mem")
@ResponseResult
@RestController
public class MemberController {

    @Autowired
    IMemberCardService memberCardService;


    @PostMapping("register")
    @ResponseBody
    @ApiOperation("会员注册接口")
    public MemberCardVo register(@RequestBody @ApiParam("会员注册表单") MemberRegisterDto memberRegisterDto) {
        MemberCardDto memberCardDto = memberCardService.openCard(memberRegisterDto);
        return coverMemberCardDto2Vo(memberCardDto);
    }
    
    @GetMapping("info/{code}")
    public MemberCardVo info(@PathVariable(name="code", required=true) String code) {
    	MemberCardDto memberCardDto = memberCardService.queryByCode(code);
    	return coverMemberCardDto2Vo(memberCardDto);
    }

    @PostMapping("/list")
    public PageResponseVo list(@RequestBody PageRequestVo pageRequestVo) {
    	PageQuery pageQuery = new PageQuery();
    	BeanCopyUtil.copyProperties(pageRequestVo, pageQuery);
    	PageResponseDto pageResponseDto = memberCardService.pageSearch(pageQuery);
        List<MemberCardVo> memberCardVos = BeanCopyUtil.copyListProperties(pageResponseDto.getItems(), MemberCardVo::new);
        pageResponseDto.setItems(memberCardVos);
        PageResponseVo pageResponseVo = new PageResponseVo();
        BeanCopyUtil.copyProperties(pageResponseDto, pageResponseVo);
        return pageResponseVo;
    }
    
    private MemberCardVo coverMemberCardDto2Vo(MemberCardDto memberCardDto) {
    	if(memberCardDto == null) {
    		return null;
    	}
    	MemberCardVo vo = new MemberCardVo();
        BeanCopyUtil.copyProperties(memberCardDto, vo);
        return vo;
	}

}
