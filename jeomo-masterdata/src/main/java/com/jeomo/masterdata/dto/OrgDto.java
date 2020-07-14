package com.jeomo.masterdata.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 权限隔离的最高粒度，不同组织的之间的数据是绝对透明的
 * @Author: qbt
 * @Date: 2020/7/7 23:00
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
public class OrgDto implements Serializable {
	
    /**  */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 组织码
	 */
	private String code;
	
    /**
     * 组织名称
     */
    private String name;
    
}
