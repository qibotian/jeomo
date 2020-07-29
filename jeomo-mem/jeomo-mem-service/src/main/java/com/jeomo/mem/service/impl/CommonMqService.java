package com.jeomo.mem.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author: qbt
 * @Date: 2020/2/28 18:11
 * @Version 1.0
 */
@Service
public class CommonMqService {

    private static final Logger log = LoggerFactory.getLogger(CommonMqService.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("member.order.exchange.name")
    private String memberOrderExchangeName;

    @Value("member.order.routing.key.name")
    private String memberOrderRoutingKeyName;

    public void sendRabbitMsg(String mobile) {
        rabbitTemplate.setExchange(memberOrderExchangeName);
        rabbitTemplate.setRoutingKey(memberOrderRoutingKeyName);
        Message message = MessageBuilder.withBody(mobile.getBytes()).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
        rabbitTemplate.send(message);
    }



}
