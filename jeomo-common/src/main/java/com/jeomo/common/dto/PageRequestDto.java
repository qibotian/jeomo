package com.jeomo.common.dto;

import java.io.Serializable;
import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("分页查询")
public class PageRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 当前页码
     */
	@ApiModelProperty("当前页码，首页从1开始")
    private long pageNumber;

    /**
     * 页面大小
     */
	@ApiModelProperty("页面大小")
    private long pageSize;

    /**
     * 排序条件
     */
	@ApiModelProperty("排序方案")
    Map<String, String> sorts;

    /**
     * 查询条件
     */
	@ApiModelProperty("搜索条件")
    Map<String, Object> searchParams;


}
