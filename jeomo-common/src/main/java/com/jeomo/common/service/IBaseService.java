package com.jeomo.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jeomo.common.dto.PageRequestDto;
import com.jeomo.common.dto.PageResponseDto;

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
	PageResponseDto pageSearch(PageRequestDto pageRequest);

}
