package com.jeomo.shiro.bean;

import com.alibaba.fastjson.JSON;
import org.crazycake.shiro.serializer.RedisSerializer;

import java.nio.charset.Charset;

/**
 * @Author: qbt
 * @Date: 2020/7/27 15:26
 * @Version 1.0
 */
public class StringRedisSerializer implements RedisSerializer {

    private final Charset charset;

    private final String target = "\"";

    private final String replacement = "";

    public StringRedisSerializer() {
        this(Charset.forName("UTF8"));
    }

    public StringRedisSerializer(Charset charset) {
        this.charset = charset;
    }

    @Override
    public String deserialize(byte[] bytes) {
        return (bytes == null ? null : new String(bytes, charset));
    }

    @Override
    public byte[] serialize(Object object) {
        String string = JSON.toJSONString(object);
        if (string == null) {
            return null;
        }
        string = string.replace(target, replacement);
        return string.getBytes(charset);
    }
}

