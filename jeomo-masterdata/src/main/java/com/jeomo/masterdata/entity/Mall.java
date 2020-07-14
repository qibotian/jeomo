package com.jeomo.masterdata.entity;

import com.jeomo.common.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 购物中心
 * @Author: qbt
 * @Date: 2020/3/1 0:06
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
public class Mall extends BaseEntity {

    /**  */
	private static final long serialVersionUID = 1L;
	
	/**
     * 所属组织
     */
    private String orgCode;

    /**
     * 同城店Id
     */
    private String groupCode;
    
    /**
     * 购物中心号
     */
    private String code;

    /**
     * 购物中心名称
     */
    private String name;



}
