package com.jeomo.sys.service;

import com.jeomo.common.service.IBaseService;
import com.jeomo.sys.dto.UserDto;
import com.jeomo.sys.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
public interface IUserService extends IBaseService<User> {

    /**
     * 根据用户名查询号用户
     * @param name
     * @return
     */
    public int removeByUsername(String username);
    
    /**
     * 根据用户名查询号用户
     * @param name
     * @return
     */
    public UserDto findByUsername(String username);

}
