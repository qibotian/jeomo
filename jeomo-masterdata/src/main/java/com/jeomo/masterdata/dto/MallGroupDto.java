package com.jeomo.masterdata.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper=false)
public class MallGroupDto implements Serializable{

	/**  */
	private static final long serialVersionUID = 1L;

	/**
	 * 族群所属的组织号
	 */
    private String orgCode;

    /**
     * 族群号
     */
    private String code; 
    
    /**
     * 族群名称
     */
    private String name;


}
