package com.jeomo.masterdata.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.jeomo.common.service.impl.BaseServiceImpl;
import com.jeomo.masterdata.dto.MallDto;
import com.jeomo.masterdata.entity.Mall;
import com.jeomo.masterdata.mapper.MallMapper;
import com.jeomo.masterdata.service.IMallService;

/**
 * @Author: qbt
 * @Date: 2020/5/8 22:18
 * @Version 1.0
 */
@Service
public class MallServiceImpl extends BaseServiceImpl<MallMapper, Mall> implements IMallService {

    @Override
    public MallDto queryMallByCode(String mallCode) {
    	Mall mall = baseMapper.queryMallByCode(mallCode);
        MallDto dto = new MallDto();
        BeanUtils.copyProperties(mall, dto);
        return dto;
    }

}
