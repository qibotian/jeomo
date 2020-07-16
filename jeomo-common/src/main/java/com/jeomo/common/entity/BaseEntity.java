package com.jeomo.common.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

/**
 * @Author: qbt
 * @Date: 2019/3/21 19:11
 * @Version 1.0
 */

@Data
public abstract class BaseEntity implements Serializable {

    /**  */
	private static final long serialVersionUID = 1L;

	/**
     * 默认使用雪花算法实现ID
     */
	@TableId(type=IdType.ID_WORKER)
    private Long id;
    
    /**
     * 版本号
     */
    private Long version;

}
