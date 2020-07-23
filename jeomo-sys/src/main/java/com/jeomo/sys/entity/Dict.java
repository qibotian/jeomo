package com.jeomo.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jeomo.common.entity.BaseEntity;
/**
 * <p>
 * 数据字典
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
@TableName("sys_dict")
public class Dict extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 类型名称
     */
    private Integer typeId;

    /**
     * 展示值
     */
    private String name;

    /**
     * 使用
     */
    private String value;

    /**
     * 是否不可更改
     */
    private String fixed;

    public Dict() {
        super();
    }

    public Dict(Integer typeId, String name, String value, String fixed) {
        super();
        this.typeId = typeId;
        this.name = name;
        this.value = value;
        this.fixed = fixed;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFixed() {
        return fixed;
    }

    public void setFixed(String fixed) {
        this.fixed = fixed;
    }
}
