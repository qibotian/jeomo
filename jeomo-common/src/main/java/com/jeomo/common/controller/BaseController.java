package com.jeomo.common.controller;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Controller 基类
 * @Author: qbt
 * @Date: 2019/3/21 19:10
 * @Version 1.0
 */

@ApiResponses({
    @ApiResponse(code=400,message="请求参数无效"),
    @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
})
public abstract class BaseController {



}
