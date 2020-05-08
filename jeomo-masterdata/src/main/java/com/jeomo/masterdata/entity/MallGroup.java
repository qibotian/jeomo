package com.jeomo.masterdata.entity;

import com.jeomo.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 同城店
 * @Author: qbt
 * @Date: 2020/3/1 0:08
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MallGroup extends BaseEntity {

    private Integer groupId;

    private String name;


}
