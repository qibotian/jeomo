package com.jeomo.mem.consumer;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * @Author: qbt
 * @Date: 2020/2/28 15:52
 * @Version 1.0
 */
@Component
public class MemberOrderListener implements ChannelAwareMessageListener {

    private static Integer GOODS_NUM = 10;

    private static Object object = new Object();

    private static final Logger log = LoggerFactory.getLogger(MemberOrderListener.class);

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long tag = message.getMessageProperties().getDeliveryTag();
        byte[] body = message.getBody();
        String mobile = new String(body, "UTF-8");
        log.info("监听到手机号:{}", mobile);
        synchronized (object) {
            if(GOODS_NUM-- > 0) {
                log.info("{}抢购成功", mobile);
                Thread.sleep(10);
            }else {
                log.info("{}抢购失败", mobile);
            }
        }
        channel.basicAck(tag, true);
    }
}
