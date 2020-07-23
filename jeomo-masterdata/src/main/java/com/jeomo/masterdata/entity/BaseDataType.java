package com.jeomo.masterdata.entity;

import com.jeomo.common.entity.BaseEntity;

/**
 * 基础数据分类名称
 * @Author: qbt
 * @Date: 2020/3/1 1:43
 * @Version 1.0
 */
public class BaseDataType extends BaseEntity {

    /**
     * 分类名称
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
