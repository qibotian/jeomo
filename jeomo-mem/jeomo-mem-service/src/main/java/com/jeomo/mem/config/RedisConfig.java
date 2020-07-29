package com.jeomo.mem.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;

/**
 * <p>标题: 自定义config</p>
 * @author qibotian
 * @time 2020年7月10日 上午9:14:53
 */
@Configuration
public class RedisConfig {
	
	/**
	 * <p>方法名称：自己定义redisTemplate</p>
	 * <p>方法说明：
	 *   1： 将默认的 RedisTemplate<Object, Object>改为RedisTemplate<String, Object>
	 *   2: 设置默认的key和value的序列化方式
	 * 
	 * </p>
	 * @param redisConnectionFactory
	 * @return
	 * @throws UnknownHostException
	 * @author qibotian
	 * @time 2020年7月10日 上午9:15:35
	 */
	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
		ObjectMapper objectMapper = new ObjectMapper();
		
		objectMapper.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.ANY);
		
		//设置json保存类型，这样反序列化时可以自动转为我们希望的类型。
		//如果不设置，则redis中默认保存为：[{"id":72,"uuid":"c4d7fc52-4096-4c79-81ef-32cb1b87fd28","type":2}]
		//如果设置了，则保存为：["java.util.ArrayList",[{"@class":"com.model.app","id":72,"uuid":"c4d7fc52-4096-4c79-81ef-32cb1b87fd28","type":2}]]
		objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.WRAPPER_ARRAY);
		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
		
		//设置key和value的默认序列化方式
		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		template.setKeySerializer(stringRedisSerializer);
		template.setHashKeySerializer(stringRedisSerializer);
		template.setValueSerializer(jackson2JsonRedisSerializer);
		template.setHashValueSerializer(jackson2JsonRedisSerializer);
		
		template.setConnectionFactory(redisConnectionFactory);
		template.afterPropertiesSet();
		return template;
	}

	
	
	
}
