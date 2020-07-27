package com.jeomo.shiro.mapper;

import com.jeomo.common.mapper.IBaseMapper;
import com.jeomo.shiro.entity.User;
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
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User queryByUsername(String username);

    /**
     * <p>方法名称：根据用户名删除用户</p>
     * @param username
     * @return
     * @author qibotian
     * @time 2020年7月17日 下午2:13:16
     */
    int removeByUsername(String username);

}
