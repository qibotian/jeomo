package com.jeomo.common.dto;

import java.io.Serializable;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 当前页码
     */
    private long pageNumber;

    /**
     * 页面大小
     */
    private long pageSize;

    /**
     * 排序条件
     */
    Map<String, String> sorts;

    /**
     * 查询条件
     */
    Map<String, Object> searchParams;


}
