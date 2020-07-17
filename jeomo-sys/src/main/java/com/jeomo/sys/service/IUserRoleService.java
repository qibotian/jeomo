package com.jeomo.sys.service;

import com.jeomo.common.service.IBaseService;
import com.jeomo.sys.entity.UserRole;

/**
 * <p>
 * 用户-角色关系表 服务类
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
public interface IUserRoleService extends IBaseService<UserRole> {

    /**
     * 删除用户所有权限
     * @param userId
     */
    void deleteByUsername(String username);

    /**
     * 批量删除用户权限
     * @param userIds
     */
    void deleteByUsernames(String[] usernames);

    /**
     * 给用户赋权
     * @param userId
     * @param roleIds
     */
    void insertUserRole(String username, String[] roleCodes);

    /**
     * 批量用户赋权
     * @param userIds
     * @param rolesIds
     */
    void insertUserRoles(String[] usernames, String[] roleCodes);


}
