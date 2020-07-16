package com.jeomo.common.query;

import java.util.Map;

import io.swagger.annotations.ApiModelProperty;

public class PageQuery {

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

	public long getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(long pageNumber) {
		this.pageNumber = pageNumber;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public Map<String, String> getSorts() {
		return sorts;
	}

	public void setSorts(Map<String, String> sorts) {
		this.sorts = sorts;
	}

	public Map<String, Object> getSearchParams() {
		return searchParams;
	}

	public void setSearchParams(Map<String, Object> searchParams) {
		this.searchParams = searchParams;
	}

}
