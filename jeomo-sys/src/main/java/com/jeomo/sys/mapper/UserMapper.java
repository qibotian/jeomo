package com.jeomo.sys.mapper;

import com.jeomo.common.mapper.IBaseMapper;
import com.jeomo.sys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;

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



}
