package com.jeomo.mem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeomo.common.result.annotation.ResponseResult;
import com.jeomo.mem.dto.MemberCardDto;
import com.jeomo.mem.dto.MemberRegisterDto;
import com.jeomo.mem.entity.Member;
import com.jeomo.mem.enums.MemberLogTypeEnum;
import com.jeomo.mem.log.MemberLog;
import com.jeomo.mem.service.IMemberService;
import com.jeomo.mem.service.impl.OrderInitServer;
import com.jeomo.mem.vo.LoginVo;
import com.jeomo.mem.vo.MemberCardVo;
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
import org.springframework.web.bind.annotation.*;

/**
 * @Author: qbt
 * @Date: 2019/3/24 20:47
 * @Version 1.0
 */
@Controller
@RequestMapping("/mem")
@ResponseResult
@RestController
public class MemController {

//    @Reference(version="${mem.service.version}")
    @Autowired
    IMemberService memberService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("log.member.exchange.name")
    private String memberExchangeName;

    @Value("log.member.routing.key.name")
    private String memberRoutingKeyName;


    @RequestMapping(value = "hi")
    @ResponseBody
    public String sayHi() {
        return "hello dubbo";
    }


    @RequestMapping("/{id}")
    @ResponseBody
    public Member get(@PathVariable Long id) {
        return  memberService.getById(id);
    }


    @RequestMapping("/t/{id}")
    public Member tGet(@PathVariable Long id) {
        return  memberService.getById(id);
    }


    @RequestMapping("register")
    @ResponseBody
    public MemberCardVo register(@RequestBody MemberRegisterDto memberRegisterDto) {
        MemberCardDto memberCardDto = memberService.register(memberRegisterDto);
        MemberCardVo vo = new MemberCardVo();
        BeanUtils.copyProperties(memberCardDto, vo);
        return vo;
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

    @Autowired
    private OrderInitServer initServer;

    @RequestMapping("robbing")
    public void robbingThread() {
        initServer.generateMultiThread();
    }


}
