package com.jeomo.common.vo;

import java.io.Serializable;
import java.util.List;

public class PageResponseVo implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 总数
     */
    private long total;

    /**
     * 数据
     */
    private List<?> items;

    public PageResponseVo() {
        super();
    }

    public PageResponseVo(long total, List<?> items) {
        super();
        this.total = total;
        this.items = items;
    }
}
