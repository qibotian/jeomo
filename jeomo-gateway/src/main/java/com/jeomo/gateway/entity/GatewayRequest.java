package com.jeomo.gateway.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 服务提供器 API 接口
 * @Author: qbt
 * @Date: 2019/3/26 20:05
 * @Version 1.0
 */
@Getter
@Setter
@Data
public class GatewayRequest implements Serializable {

    /**
     * 请求的应用ID
     */
    private String appId;

    /**
     * contexPath
     */
    private String contextPath;

    /**
     * 请求版本号
     */
    private String version;

    /**
     * 源地址 http://gateway:port/contextPath/...
     * 请求路径
     */
    private String url;

    /**
     * 获取路径
     *  contextPath/...
     */
    private String path;

    public GatewayRequest(String url) {
        this.url = url;
        parse();
    }

    private void parse() {
        //TODO
        this.appId = "";
        this.contextPath="";
        this.path="";
        this.version="";
    }

    public  String getServerAddr() {
        StringBuffer sb = new StringBuffer();
        if (url != null) {
            sb.append("/");
            sb.append(url);
        } else {
            sb.append("/");
        }
        this.url = sb.toString();
        return url;
    }





}
