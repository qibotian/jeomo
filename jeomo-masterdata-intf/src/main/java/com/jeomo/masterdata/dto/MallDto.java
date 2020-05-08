package com.jeomo.masterdata.dto;

/**
 * @Author: qbt
 * @Date: 2020/5/8 22:17
 * @Version 1.0
 */
public class MallDto {

    /**
     * 同城店Id
     */
    private Integer groupId;

    /**
     * 购物中心编号
     */
    private Integer mallId;

    /**
     * 购物中心名称
     */
    private String name;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getMallId() {
        return mallId;
    }

    public void setMallId(Integer mallId) {
        this.mallId = mallId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
