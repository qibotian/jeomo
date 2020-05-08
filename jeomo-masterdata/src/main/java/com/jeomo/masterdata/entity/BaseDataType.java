package com.jeomo.masterdata.entity;

import com.jeomo.common.entity.BaseEntity;
import lombok.*;

/**
 * 基础数据分类名称
 * @Author: qbt
 * @Date: 2020/3/1 1:43
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseDataType extends BaseEntity {

    /**
     * 分类名称
     */
    private String name;


}
