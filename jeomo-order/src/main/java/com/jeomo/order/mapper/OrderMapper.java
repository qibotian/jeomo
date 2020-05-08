package com.jeomo.order.mapper;

import com.jeomo.common.mapper.IBaseMapper;
import com.jeomo.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * 基础数据mapper
 * @Author: qbt
 * @Date: 2020/3/1 16:36
 * @Version 1.0
 */
@Mapper
public interface OrderMapper extends IBaseMapper<Order> {

}
