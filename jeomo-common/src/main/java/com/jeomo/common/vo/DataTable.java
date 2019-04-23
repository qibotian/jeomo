package com.jeomo.common.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Author: qbt
 * @Date: 2019/3/21 23:26
 * @Version 1.0
 */

@Getter
@Setter
public class DataTable<T> implements Serializable {

    /**
     * 总数
     */
    private long total;

    /**
     * 数据
     */
    private List<T> items;

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
