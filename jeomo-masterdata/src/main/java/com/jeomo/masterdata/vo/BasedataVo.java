package com.jeomo.masterdata.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: qbt
 * @Date: 2020/3/1 16:28
 * @Version 1.0
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasedataVo {

    private Long typeId;

    private Integer code;

    private String name;

}
