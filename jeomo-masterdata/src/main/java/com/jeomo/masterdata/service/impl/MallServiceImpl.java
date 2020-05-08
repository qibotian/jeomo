package com.jeomo.masterdata.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jeomo.common.service.impl.BaseServiceImpl;
import com.jeomo.masterdata.dto.MallDto;
import com.jeomo.masterdata.entity.Mall;
import com.jeomo.masterdata.mapper.MallMapper;
import com.jeomo.masterdata.service.IMallService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @Author: qbt
 * @Date: 2020/5/8 22:18
 * @Version 1.0
 */
@Service
public class MallServiceImpl extends BaseServiceImpl<MallMapper, Mall> implements IMallService {

    @Override
    public MallDto queryMallByMallId(Integer mallId) {
        Wrapper<Mall> wrapper = new QueryWrapper<>();
        ((QueryWrapper<Mall>) wrapper).eq("mall_Id", mallId);
        Mall mall = this.baseMapper.selectOne(wrapper);
        MallDto dto = new MallDto();
        BeanUtils.copyProperties(mall, dto);
        return dto;
    }

}
