package com.jeomo.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: qbt
 * @Date: 2019/3/21 19:11
 * @Version 1.0
 */

@Data
public abstract class BaseEntity implements Serializable {

    /**
     * 物理主键，没有任何业务含义
     * 其他表禁止关联此Id
     */
    private Long id;

    /**
     * 版本号
     */
    private Long version;

}
