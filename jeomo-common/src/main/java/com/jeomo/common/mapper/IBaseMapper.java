package com.jeomo.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jeomo.common.entity.BaseEntity;

/**
 * @Author: qbt
 * @Date: 2019/3/21 19:10
 * @Version 1.0
 */
public interface IBaseMapper<T extends BaseEntity> extends BaseMapper<T> {
}
