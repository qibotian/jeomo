package com.jeomo.mem.controller;

import com.jeomo.common.dto.PageResponseDto;
import com.jeomo.common.query.PageQuery;
import com.jeomo.common.result.annotation.ResponseResult;
import com.jeomo.common.util.BeanCopyUtil;
import com.jeomo.common.vo.PageRequestVo;
import com.jeomo.common.vo.PageResponseVo;
import com.jeomo.mem.intf.dto.MemberCardDto;
import com.jeomo.mem.intf.dto.MemberRegisterDto;
import com.jeomo.mem.intf.vo.MemberCardVo;
import com.jeomo.mem.service.IMemberCardService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * @Author: qbt
 * @Date: 2019/3/24 20:47
 * @Version 1.0
 */
@Controller
@RequestMapping("/mem")
@ResponseResult
@RestController
public class MemberController {

    final Logger logger  = Logger.getLogger(this.getClass().getName());


    @Autowired
    IMemberCardService memberCardService;

    @Value("${server.port}")
    private String port;


    @GetMapping("test/{code}")
    @RequiresRoles("ADMIN")
    @HystrixCommand(fallbackMethod = "testFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
        })
    public String test(@PathVariable(name="code", required=true) String code) throws InterruptedException {
        System.out.println("O(∩_∩)O哈哈~");
        return "O(∩_∩)O哈哈~,端口 " + port + " 接收到请求码： " + code ;
    }

    public String testFallback(@PathVariable(name="code", required=true) String code) throws InterruptedException {
        return "会员服务繁忙，会员(╥╯^╰╥)";
    }


    @PostMapping("register")
    @ResponseBody
    @ApiOperation("会员注册接口")
    public MemberCardVo register(@RequestBody @ApiParam("会员注册表单") MemberRegisterDto memberRegisterDto) {
        MemberCardDto memberCardDto = memberCardService.openCard(memberRegisterDto);
        return coverMemberCardDto2Vo(memberCardDto);
    }

    @GetMapping("info/{code}")
    public MemberCardVo info(@PathVariable(name="code", required=true) String code) {
    	MemberCardDto memberCardDto = memberCardService.queryByCode(code);
    	return coverMemberCardDto2Vo(memberCardDto);
    }

    @PostMapping("/list")
    public PageResponseVo list(@RequestBody PageRequestVo pageRequestVo) {
    	PageQuery pageQuery = new PageQuery();
    	BeanCopyUtil.copyProperties(pageRequestVo, pageQuery);
    	PageResponseDto pageResponseDto = memberCardService.pageSearch(pageQuery);
        List<MemberCardVo> memberCardVos = BeanCopyUtil.copyListProperties(pageResponseDto.getItems(), MemberCardVo::new);
        pageResponseDto.setItems(memberCardVos);
        PageResponseVo pageResponseVo = new PageResponseVo();
        BeanCopyUtil.copyProperties(pageResponseDto, pageResponseVo);
        return pageResponseVo;
    }

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        logger.info("获取服务");
        for(String service : services) {
            logger.info("******发现服务：" + service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for(ServiceInstance instance: instances) {
                logger.info("******发现实例：" + instance.getHost() + ":" + instance.getPort() + "\t" + instance.getUri());
            }
        }
        return discoveryClient;
    }


    private MemberCardVo coverMemberCardDto2Vo(MemberCardDto memberCardDto) {
    	if(memberCardDto == null) {
    		return null;
    	}
    	MemberCardVo vo = new MemberCardVo();
        BeanCopyUtil.copyProperties(memberCardDto, vo);
        return vo;
	}



}
