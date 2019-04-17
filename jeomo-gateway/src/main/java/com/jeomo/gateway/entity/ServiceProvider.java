package com.jeomo.gateway.entity;

import com.jeomo.gateway.utils.CommonCodeConstants;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 服务提供者
 * @Author: qbt
 * @Date: 2019/4/2 19:24
 * @Version 1.0
 */

@Data
public class ServiceProvider {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 主机地址
     */
    private String host;

    /**
     * 端口号
     */
    private String port;

    /**
     * 服务地址
     */
    private String contextPath;

    /**
     * 节点内容
     */
    private String content;

    public ServiceProvider(String content) {
        try {
            content = URLDecoder.decode(content, CommonCodeConstants.CHARTSET_UTF_8);
        } catch (UnsupportedEncodingException e) {
            logger.debug("节点解析失败：{}" , e );
        }
        this.content = content;
        parse();
    }

    /**
     * 开始解析节点
     */
    private void parse() {
        // 10.254.0.159:8002/mem/com.jeomo.mem.service.IMemberService:sdasda311//dasd31s
        String substring = content.substring(CommonCodeConstants.REST_SLASH.length());
        // 10.254.0.159
        this.host = substring.substring(0, substring.indexOf(CommonCodeConstants.COLON));
        // 8002
        this.port = substring.substring(substring.indexOf(CommonCodeConstants.COLON) + 1, substring.indexOf(CommonCodeConstants.SLASH));
        substring = substring.substring(substring.indexOf(CommonCodeConstants.SLASH) + 1);
        this.contextPath = substring.substring(0, substring.indexOf(CommonCodeConstants.SLASH));
    }

    /**
     * 获取服务地址 host:port
     * @return
     */
    public String getServerHost() {
        return String.format("%s:%s", host, port);
    }

}
