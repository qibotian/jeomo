package com.jeomo.common.vo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageResponseVo implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 总数
     */
    private long total;

    /**
     * 数据
     */
    private List<?> items;


}
