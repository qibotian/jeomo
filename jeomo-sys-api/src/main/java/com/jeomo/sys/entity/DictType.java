package com.jeomo.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jeomo.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 字典类型
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_dict_type")
public class DictType extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 类型名称
     */
    private String name;


}
