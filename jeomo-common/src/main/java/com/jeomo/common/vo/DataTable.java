package com.jeomo.common.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: qbt
 * @Date: 2019/3/21 23:26
 * @Version 1.0
 */

@Getter
@Setter
public class DataTable<T> implements Serializable {

    /**
     * 返回码
     */
    private  String code;

    /**
     * 返回信息
     */
    private  String msg;

    /**
     * 总数
     */
    private long total;

    /**
     * 数据
     */
    private List<T> data;

    /**
     * 当前页码
     */
    private long pageNumber;

    /**
     * 页面大小
     */
    private long pageSize;




}
