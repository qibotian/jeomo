package com.jeomo.mem.controller.web;

import com.jeomo.common.result.annotation.ResponseResult;
import com.jeomo.common.util.BeanCopyUtil;
import com.jeomo.mem.api.dto.MemberCardDto;
import com.jeomo.mem.api.dto.MemberRegisterDto;
import com.jeomo.mem.api.vo.MemberCardVo;
import com.jeomo.mem.api.vo.MemberRegisterVo;
import com.jeomo.mem.service.IMemberCardService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mem/card")
@ResponseResult
public class MemberCardController {

    @Autowired
    IMemberCardService memberCardService;

    @PostMapping("register")
    @ResponseBody
    @ApiOperation("会员注册接口")
    public MemberCardVo register(@RequestBody @ApiParam("会员注册表单") MemberRegisterVo memberRegisterVo) {
        MemberRegisterDto dto = BeanCopyUtil.copyProperties(memberRegisterVo, MemberRegisterDto.class);
        MemberCardDto memberCardDto = memberCardService.openCard(dto);
        return memberCardDto.toVo();
    }


    @GetMapping("info")
    @ApiOperation("修改会员信息接口")
    public MemberCardVo changeInfo(@RequestBody @ApiParam("会员信息修改表单") MemberRegisterDto memberRegisterDto) {
        String cardNo = "123456";
        MemberCardDto memberCardDto = memberCardService.queryByCode(cardNo);
        return memberCardDto.toVo();
    }




}
