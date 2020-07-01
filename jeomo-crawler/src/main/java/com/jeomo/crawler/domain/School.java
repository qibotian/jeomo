package com.jeomo.crawler.domain;

import com.jeomo.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: qbt
 * @Date: 2020/6/27 11:43
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class School extends BaseEntity {
    private String name;
    private String address;
    private String phone;
}
