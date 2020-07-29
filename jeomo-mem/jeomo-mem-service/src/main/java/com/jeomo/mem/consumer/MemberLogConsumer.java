package com.jeomo.mem.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeomo.mem.log.MemberLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 会员日志监听器
 * @Author: qbt
 * @Date: 2020/2/28 12:47
 * @Version 1.0
 */
@Component
public class MemberLogConsumer {

    private static final Logger log = LoggerFactory.getLogger(MemberLogConsumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 监听会员日志
     */
    @RabbitListener(queues = "${log.member.queue.name}", containerFactory  = "singleListenerContainer")
    public void consume(@Payload byte[] message) {
        try {
            MemberLog memberLog = objectMapper.readValue(message, MemberLog.class);
            log.info("监听消费用户日志 监听到消息： {} ", memberLog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
