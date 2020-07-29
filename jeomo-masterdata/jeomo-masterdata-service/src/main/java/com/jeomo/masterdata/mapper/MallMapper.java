package com.jeomo.masterdata.mapper;

import com.jeomo.common.mapper.IBaseMapper;
import com.jeomo.masterdata.entity.Mall;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 购物中心Mapper
 * @Author: qbt
 * @Date: 2020/5/8 22:19
 * @Version 1.0
 */
@Mapper
public interface MallMapper extends IBaseMapper<Mall> {


    @Select("select * from sys_mall where code = #{code}")
    Mall queryMallByCode(String code);

}
