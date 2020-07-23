package com.jeomo.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * @Author: qbt
 * @Date: 2019/3/21 19:11
 * @Version 1.0
 */

public abstract class BaseEntity implements Serializable {

    /**  */
	private static final long serialVersionUID = 1L;

	/**
     * 默认使用雪花算法实现ID
     * <p>
     * 任何数据库关联主键都不应该关联这个ID，而是应该关联相应的业务ID，比如流水号，会员号等等
     * <p>
     * 这样做的目的是，如果以后需要分库或者分离服务，分离出去的服务就可以根据自己的业务特点而定义自己的主键策略，而且不用考虑到ID变化后对别的业务的影响。
     *  <p>
     * 而业务ID因为是和业务强关联的，所以一般情况下，即时分离出去服务，也不会随意更改业务ID
     */
	@TableId(type=IdType.ID_WORKER)
    private Long id;
    
    /**
     * 版本号
     */
    private Long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
