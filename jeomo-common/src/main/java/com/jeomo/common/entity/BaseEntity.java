package com.jeomo.common.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: qbt
 * @Date: 2019/3/21 19:11
 * @Version 1.0
 */

@Data
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人ID
     */
    private Long createUserId;

    /**
     * 最后修改人ID
     */
    private Long lastModifyUserId;

    /**
     * 最后修改时间
     */
    private Date lastModifyTime;

    /**
     * 版本号
     */
    private Long version;

}
