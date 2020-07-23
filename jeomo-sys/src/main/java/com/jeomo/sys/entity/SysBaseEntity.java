package com.jeomo.sys.entity;

import java.util.Date;

import com.jeomo.common.entity.BaseEntity;

/**
 * <p>标题: 系统管理的基础实体类</p>
 * @author qibotian
 * @time 2020年7月17日 上午10:57:28
 */

public class SysBaseEntity extends BaseEntity {

	/**  */
	private static final long serialVersionUID = 1L;

	/**
     * 创建人
     */
    private String createUser;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 最后修改人
     */
    private String lastModifyUser;
    
    /**
     * 最后修改时间
     */
    private Date lastModifyTime;

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastModifyUser() {
        return lastModifyUser;
    }

    public void setLastModifyUser(String lastModifyUser) {
        this.lastModifyUser = lastModifyUser;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}
