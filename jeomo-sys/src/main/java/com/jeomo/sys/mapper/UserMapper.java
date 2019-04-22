package com.jeomo.sys.mapper;

import com.jeomo.common.mapper.IBaseMapper;
import com.jeomo.sys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
@Mapper
@CacheConfig(cacheNames = "sysUsers")
public interface UserMapper extends IBaseMapper<User> {
    /**
     * 根据Id获取用户信息
     * @param id
     * @return
     */
    @Cacheable(key ="#p0")
    @Select("select * from 123123123 where id =#{id}")
    User selectById(Integer id);

    @CachePut(key = "#p0")
    @Update("update sys_user set name=#{name} where id=#{id}")
    @Override
    int updateById(@Param("et") User user);


}
