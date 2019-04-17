package com.jeomo.gateway.service.support;

import com.jeomo.gateway.entity.GatewayRequest;
import com.jeomo.gateway.entity.ServiceProvider;
import com.jeomo.gateway.service.ApiInterfaceService;
import com.jeomo.gateway.utils.CommonCodeConstants;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 基于Zookeeper实现的 API 服务
 * @Author: qbt
 * @Date: 2019/3/26 20:14
 * @Version 1.0
 */

@Component
public class ZkApiInterfaceServiceImpl implements ApiInterfaceService {

    private static final ConcurrentHashMap<String, Set<String>> PROVIDERS_HOST = new ConcurrentHashMap<>();

    private Logger logger = LoggerFactory.getLogger(ZkApiInterfaceServiceImpl.class);

    @Value("${jeomo.gateway.server.zk.services}")
    private String zkServices;

    @Value("${jeomo.gateway.server.zk.rootpath}")
    private String rootPath;

    @Value("${jeomo.gateway.server.zk.connectionTimeOut}")
    private int connectionTimeOut;

    private ZkClient zkClient;



    @PostConstruct
    public void init() {
        logger.debug("ZkApiInterfaceServiceImpl init ...");
        zkClient = new ZkClient(zkServices, connectionTimeOut);
        if(!rootPath.startsWith(CommonCodeConstants.SLASH)) {
            rootPath = CommonCodeConstants.SLASH + rootPath;
        }
        initServices(zkClient, rootPath);
    }

    /**
     * 初始化服务
     * @param zkClient
     * @param path 路径
     */
    private void initServices(final ZkClient zkClient,final String path) {
        //解除所有的监听事件
        zkClient.unsubscribeAll();
        ConcurrentHashMap<String, Set<String>> newHosts = new ConcurrentHashMap<>();
        subscribeChildChanges(zkClient, path, path);
        /**
         * 获取子节点
         */
        //  节点路径为：dubbo/IMemberService/providers
        List<String> interfaceNodes = zkClient.getChildren(path);
        if(interfaceNodes != null && interfaceNodes.size() > 0) {
            for(String child : interfaceNodes) {
                String interfacePath = path + CommonCodeConstants.SLASH  + child;
                logger.debug(interfacePath);
                subscribeChildChanges(zkClient, interfacePath, path);
                // 获取providers层
                List<String> typeNodes = zkClient.getChildren(interfacePath);
                if(typeNodes != null && typeNodes.size() > 0) {
                    for(String typeNode : typeNodes) {
                        if(typeNode.startsWith(CommonCodeConstants.PROVIDERS)) {
                            String typePath = interfacePath + CommonCodeConstants.SLASH + typeNode;
                            subscribeChildChanges(zkClient, typePath, path);
                            List<String> serviceNodes = zkClient.getChildren(typePath);
                            if(serviceNodes != null && serviceNodes.size() > 0) {
                                for(String serviceNode : serviceNodes) {
                                    // 节点为：rest://contextpath/.....
                                    if(serviceNode.startsWith(CommonCodeConstants.REST)) {
                                        //获取contextPath
                                        ServiceProvider provider = new ServiceProvider(serviceNode);
                                        Set<String> hosts = newHosts.get(provider.getContextPath());
                                        if(hosts == null) {
                                            hosts = new HashSet<>();
                                            newHosts.put(provider.getContextPath(), hosts);
                                        }
                                        hosts.add(provider.getServerHost());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        synchronized (this) {
            logger.debug("all subscribed services ：{}", PROVIDERS_HOST.toString());
            PROVIDERS_HOST.clear();
            PROVIDERS_HOST.putAll(newHosts);
        }
    }

    /**
     *
     * @param restServiceNodeContent  dubbo 节点内容 eg: rest://ip:port/contextPath/serviceName/...
     * @return
     */
    private String getContextPath(String restServiceNodeContent) {

        return null;
    }

    private void subscribeChildChanges(final ZkClient zkclient, final String path, final String basePath) {
        zkClient.subscribeChildChanges(path, new IZkChildListener() {
            @Override
            public void handleChildChange(String parentPath, List<String> childs) throws Exception {
                logger.debug("{}'s child changed, currentChilds:{}", parentPath, childs);
                //如果有任何节点变化，则重来
                initServices(zkClient, basePath);
            }
        });
    }

    @PreDestroy
    public void destory() {
        logger.debug("ZkApiInterfaceServiceImpl destory ...");
    }

    @Override
    public String getServiceProvider(GatewayRequest request) {
        init();
        Set<String> hosts = PROVIDERS_HOST.get(request.getContextPath());
        return (String) hosts.toArray()[0] + CommonCodeConstants.SLASH + request.getPath();
    }
}
