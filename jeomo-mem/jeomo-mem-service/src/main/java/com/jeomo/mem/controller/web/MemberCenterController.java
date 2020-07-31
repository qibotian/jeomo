package com.jeomo.mem.controller.web;

import com.jeomo.mem.api.dto.MemberCardDto;
import com.jeomo.mem.api.vo.MemberCardVo;
import com.jeomo.mem.service.IMemberCardService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这个接口主要是针对当前登录会员调用的接口，
 * 所以调用所有接口之前，都需要认证登录后才可以调用
 */
@RestController("mem/center")
public class MemberCenterController {

    @Autowired
    IMemberCardService memberCardService;

    @GetMapping("info")
    @ApiOperation("获取当前用户接口")
    public MemberCardVo info() {
        //
        String cardNo = "123456";
        MemberCardDto memberCardDto = memberCardService.queryByCode(cardNo);
        return memberCardDto.toVo();
    }


    @GetMapping("info")
    @ApiOperation("修改会员信息接口")
    public MemberCardVo changeInfo() {
        String cardNo = "123456";
        MemberCardDto memberCardDto = memberCardService.queryByCode(cardNo);
        return memberCardDto.toVo();
    }


}
