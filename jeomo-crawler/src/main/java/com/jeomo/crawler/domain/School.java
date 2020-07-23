package com.jeomo.crawler.domain;

import com.jeomo.common.entity.BaseEntity;


/**
 * @Author: qbt
 * @Date: 2020/6/27 11:43
 * @Version 1.0
 */

public class School extends BaseEntity {
    private String name;
    private String address;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
