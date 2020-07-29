package com.jeomo.mem.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: qbt
 * @Date: 2020/2/27 23:58
 * @Version 1.0
 */
@Configuration
public class RabbitmqConfig {

    private static final Logger log = LoggerFactory.getLogger(RabbitmqConfig.class);

    @Value("#{T(java.lang.Integer).parseInt('${spring.rabbitmq.listener.simple.concurrency}')}")
    private int concurrentConsumers;

    @Value("#{${spring.rabbitmq.listener.simple.max-concurrency}}")
    private int maxConcurrentConsumers;

    @Value("#{${spring.rabbitmq.listener.simple.prefetch}}")
    private int prefetch;

    @Autowired
    private CachingConnectionFactory connectionFactory;

    @Autowired
    private SimpleRabbitListenerContainerFactoryConfigurer factoryConfigurer;

    /**
     * 单一消费者
     * @return
     */
    @Bean(name="singleListenerContainer")
    public SimpleRabbitListenerContainerFactory listnerContainer() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        factory.setConcurrentConsumers(1);
        factory.setMaxConcurrentConsumers(1);
        factory.setPrefetchCount(1);
        factory.setTxSize(1);
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
        return factory;
    }

    /**
     * 多个消费者
     * @return
     */
    @Bean(name="multiListenerContainer")
    public SimpleRabbitListenerContainerFactory multiListenerContainer() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factoryConfigurer.configure(factory, connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        factory.setAcknowledgeMode(AcknowledgeMode.NONE);
        factory.setConcurrentConsumers(concurrentConsumers);
        factory.setMaxConcurrentConsumers(maxConcurrentConsumers);
        factory.setPrefetchCount(prefetch);
        return factory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        connectionFactory.setPublisherConfirms(true);
        connectionFactory.setPublisherReturns(true);
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                log.info("消息发送成功:correlationData({}),ack({}),cause({})", correlationData, ack, cause);
            }
        });
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                log.info("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}", exchange, routingKey, replyCode, replyText, message);
            }
        });
        return  rabbitTemplate;
    }


    //用户操作日志消息模型
    @Value("log.member.queue.name")
    private String memberQueueName;

    @Value("log.member.exchange.name")
    private String memberExchangeName;

    @Value("log.member.routing.key.name")
    private String memberRoutingKeyName;

    @Value("member.register.queue.name")
    private String memberRegisterQueueName;

    @Value("member.register.exchange.name")
    private String memberRegisterExchangeName;


    /**
     * 会员注册队列
     * @return
     */
    @Bean
    public Queue memberRegisterQueue() {
        return new Queue(memberRegisterQueueName, true);
    }

    @Bean
    public Exchange memberRegisterExchange() {
        return new TopicExchange(memberRegisterExchangeName, true, false);
    }


    @Bean
    public Queue logMemberQueue() {
        return new Queue(memberQueueName, true); //消息持久
    }

    @Bean
    public DirectExchange logMemberExchange() {
        return new DirectExchange(memberExchangeName, true, true);
    }

    @Bean
    public Binding logMemberBinding() {
        return BindingBuilder.bind(logMemberQueue()).to(logMemberExchange()).with(memberRoutingKeyName);
    }






}
