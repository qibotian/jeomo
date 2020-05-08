package com.jeomo.masterdata.controller;

import com.jeomo.common.controller.BaseController;
import com.jeomo.common.result.annotation.ResponseResult;
import com.jeomo.masterdata.entity.BaseData;
import com.jeomo.masterdata.service.IBaseDataService;
import com.jeomo.masterdata.vo.BasedataVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: qbt
 * @Date: 2020/3/1 16:27
 * @Version 1.0
 */
@RequestMapping("/masterdata/basedata")
@ResponseResult
@RestController
public class BasedataController extends BaseController {

    @Autowired
    IBaseDataService baseDataService;

    @PostMapping("save")
    public boolean save(@RequestBody BasedataVo vo) {
        BaseData baseData = new BaseData();
        BeanUtils.copyProperties(vo, baseData);
        System.out.println(baseData);
        return baseDataService.save(baseData);
    }


}
