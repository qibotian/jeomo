package com.jeomo.mem.controller;

import java.util.List;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.AbstractJavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeomo.common.dto.PageRequestDto;
import com.jeomo.common.dto.PageResponseDto;
import com.jeomo.common.result.annotation.ResponseResult;
import com.jeomo.common.util.BeanCopyUtil;
import com.jeomo.mem.dto.MemberCardDto;
import com.jeomo.mem.dto.MemberRegisterDto;
import com.jeomo.mem.enums.MemberLogTypeEnum;
import com.jeomo.mem.log.MemberLog;
import com.jeomo.mem.service.IMemberCardService;
import com.jeomo.mem.service.IMemberService;
import com.jeomo.mem.vo.LoginVo;
import com.jeomo.mem.vo.MemberCardVo;

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
    IMemberService memberService;

    @Autowired
    IMemberCardService memberCardService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("log.member.exchange.name")
    private String memberExchangeName;

    @Value("log.member.routing.key.name")
    private String memberRoutingKeyName;


    @PostMapping("register")
    @ResponseBody
    @ApiOperation("会员注册接口")
    public MemberCardVo register(@RequestBody @ApiParam("会员注册表单") MemberRegisterDto memberRegisterDto) {
        MemberCardDto memberCardDto = memberService.register(memberRegisterDto);
        MemberCardVo vo = new MemberCardVo();
        BeanUtils.copyProperties(memberCardDto, vo);
        return vo;
    }

    @PostMapping("/list")
    public PageResponseDto list(@RequestBody PageRequestDto pageRequestDto) {
        PageResponseDto pageResponseDto = memberCardService.pageSearch(pageRequestDto);
        List<MemberCardVo> memberCardVos = BeanCopyUtil.copyListProperties(pageResponseDto.getItems(), MemberCardVo::new);
        pageResponseDto.setItems(memberCardVos);
        return pageResponseDto;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public void login(@RequestBody LoginVo loginVo) {
        MemberLog log = MemberLog.builder().type(MemberLogTypeEnum.LOGIN).memberId(123L).message("成功").build();
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setExchange(memberExchangeName);
        rabbitTemplate.setRoutingKey(memberRoutingKeyName);
        try {
            Message message = MessageBuilder.withBody(objectMapper.writeValueAsBytes(log)).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
            message.getMessageProperties().setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME, MessageProperties.CONTENT_TYPE_JSON);
            rabbitTemplate.convertAndSend(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }



}
