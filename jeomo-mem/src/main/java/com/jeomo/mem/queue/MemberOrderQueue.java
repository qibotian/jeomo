package com.jeomo.mem.queue;

import com.jeomo.mem.consumer.MemberOrderListener;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 会员下单队列
 * @Author: qbt
 * @Date: 2020/2/28 15:17
 * @Version 1.0
 */
@Component
public class MemberOrderQueue {

    @Value("member.order.queue.name")
    private String memberOrderQueueName;
    @Value("member.order.exchange.name")
    private String memberOrderExchangeName;
    @Value("member.order.routing.key.name")
    private String memberOrderRoutingKeyName;
    @Value("#{T(java.lang.Integer).parseInt('${spring.rabbitmq.listener.simple.concurrency}')}")
    private int concurrentConsumers;
    @Value("#{${spring.rabbitmq.listener.simple.max-concurrency}}")
    private int maxConcurrentConsumers;
    @Value("#{${spring.rabbitmq.listener.simple.prefetch}}")
    private int prefetch;

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private MemberOrderListener memberOrderListener;

    @Bean(name="memberOrderQueue1")
    public Queue memberOrderQueue(){
        return new Queue(memberOrderQueueName, true);
    }

    @Bean(name="memberOrderExchange")
    public TopicExchange memberOrderExchange() {
        return new TopicExchange(memberOrderExchangeName, true, false);
    }

    @Bean(name="memberOrderBinding")
    public Binding memberOrderBinding() {
        return BindingBuilder.bind(memberOrderQueue()).to(memberOrderExchange()).with(memberOrderRoutingKeyName);
    }

    @Bean
    public SimpleMessageListenerContainer listenerContainerMemberOrder(@Qualifier("memberOrderQueue1") Queue memberOrderQueue) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        //container.setMessagePropertiesConverter(new Jackson2JsonMessageConverter());

        //并发配置
        container.setConcurrentConsumers(concurrentConsumers);
        container.setMaxConcurrentConsumers(maxConcurrentConsumers);
        container.setPrefetchCount(prefetch);

        //消息确认机制
        container.setQueues(memberOrderQueue);
        container.setMessageListener(memberOrderListener);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return container;
    }

}
