package com.jeomo.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jeomo.common.dto.PageResponseDto;
import com.jeomo.common.query.PageQuery;

/**
 * @Author: qbt
 * @Date: 2019/3/21 18:56
 * @Version 1.0
 */
public interface IBaseService<T> extends IService<T> {

    /**
     * 分页搜索
     * @param dt
     * @return
     */
	PageResponseDto pageSearch(PageQuery pageRequest);

}
