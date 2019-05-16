package com.jeomo.sys.mapper;

import com.jeomo.common.mapper.IBaseMapper;
import com.jeomo.sys.entity.User;
import lombok.NonNull;
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

    /**
     * 根据登录名查询
     * @param loginName
     * @return
     */
    User selectByLoginName(@NonNull String loginName);

    /**
     * 根据ID查询用户全部信息
     * @param id
     * @return
     */
    User selectAllInfoById(@NonNull Long id);

}
