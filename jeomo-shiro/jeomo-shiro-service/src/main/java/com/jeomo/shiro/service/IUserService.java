package com.jeomo.shiro.service;

import com.jeomo.common.service.IBaseService;
import com.jeomo.shiro.dto.UserDto;
import com.jeomo.shiro.entity.User;

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
     * @param username
     * @return
     */
    public int removeByUsername(String username);

    /**
     * 根据用户名查询号用户
     * @param username
     * @return
     */
    public UserDto queryByUsername(String username);

    /**
     * 根据用户名查询用户信息（含角色信息）
     * @param username
     * @return
     */
    public UserDto queryAllInfoByUsername(String username);

}
