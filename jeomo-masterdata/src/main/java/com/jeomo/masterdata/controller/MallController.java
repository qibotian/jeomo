package com.jeomo.masterdata.controller;

import com.jeomo.masterdata.dto.MallDto;
import com.jeomo.masterdata.service.IMallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: qbt
 * @Date: 2020/5/8 22:43
 * @Version 1.0
 */
@ResponseBody
@RequestMapping("/masterdata/mall")
@RestController
public class MallController {

    @Autowired
    private IMallService mallService;

    @RequestMapping("/{mallId}")
    @ResponseBody
    public MallDto get(@PathVariable Integer mallId) {
        return  mallService.queryMallByMallId(mallId);
    }


}
