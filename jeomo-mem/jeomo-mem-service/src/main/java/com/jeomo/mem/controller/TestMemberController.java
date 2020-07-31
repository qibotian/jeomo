package com.jeomo.mem.controller;

//import com.jeomo.shiro.dto.UserDto;

/**
 * @Author: qbt
 * @Date: 2019/3/24 20:47
 * @Version 1.0
 */
//@RequestMapping("/mem")
//@ResponseResult
//@RestController
public class TestMemberController {

//    final Logger logger  = Logger.getLogger(this.getClass().getName());
//
//
//    @Autowired
//    IMemberCardService memberCardService;
//
//    @Value("${server.port}")
//    private String port;


//    @GetMapping("test/{code}")
//    @RequiresRoles("ADMIN")
//    @HystrixCommand(fallbackMethod = "testFallback", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
//        })
//    public String test(@PathVariable(name="code", required=true) String code) throws InterruptedException {
//        UserDto user = (UserDto)(SecurityUtils.getSubject().getPrincipal());
//        return "O(∩_∩)O哈哈~, 你好，" + user.getUsername() + ", 端口 " + port + " 接收到请求码： " + code ;
//    }

//    public String testFallback(@PathVariable(name="code", required=true) String code) throws InterruptedException {
//        return "会员服务繁忙，会员(╥╯^╰╥)";
//    }
//
//
//    @PostMapping("register")
//    @ResponseBody
//    @ApiOperation("会员注册接口")
//    public MemberCardVo register(@RequestBody @ApiParam("会员注册表单") MemberRegisterDto memberRegisterDto) {
//        MemberCardDto memberCardDto = memberCardService.openCard(memberRegisterDto);
//        return coverMemberCardDto2Vo(memberCardDto);
//    }
//
//    @GetMapping("info/{code}")
//    public MemberCardVo info(@PathVariable(name="code", required=true) String code) {
//    	MemberCardDto memberCardDto = memberCardService.queryByCode(code);
//    	return coverMemberCardDto2Vo(memberCardDto);
//    }
//
//    @PostMapping("/list")
//    public PageResponseVo list(@RequestBody PageRequestVo pageRequestVo) {
//    	PageQuery pageQuery = new PageQuery();
//    	BeanCopyUtil.copyProperties(pageRequestVo, pageQuery);
//    	PageResponseDto pageResponseDto = memberCardService.pageSearch(pageQuery);
//        List<MemberCardVo> memberCardVos = BeanCopyUtil.copyListProperties(pageResponseDto.getItems(), MemberCardVo::new);
//        pageResponseDto.setItems(memberCardVos);
//        PageResponseVo pageResponseVo = new PageResponseVo();
//        BeanCopyUtil.copyProperties(pageResponseDto, pageResponseVo);
//        return pageResponseVo;
//    }
//
//    @Autowired
//    DiscoveryClient discoveryClient;
//
//    @GetMapping("/discovery")
//    public Object discovery() {
//        List<String> services = discoveryClient.getServices();
//        logger.info("获取服务");
//        for(String service : services) {
//            logger.info("******发现服务：" + service);
//            List<ServiceInstance> instances = discoveryClient.getInstances(service);
//            for(ServiceInstance instance: instances) {
//                logger.info("******发现实例：" + instance.getHost() + ":" + instance.getPort() + "\t" + instance.getUri());
//            }
//        }
//        return discoveryClient;
//    }
//
//
//    private MemberCardVo coverMemberCardDto2Vo(MemberCardDto memberCardDto) {
//    	if(memberCardDto == null) {
//    		return null;
//    	}
//    	MemberCardVo vo = new MemberCardVo();
//        BeanCopyUtil.copyProperties(memberCardDto, vo);
//        return vo;
//	}



}
