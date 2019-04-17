package com.jeomo.sys.service.impl;

import com.jeomo.common.service.impl.BaseServiceImpl;
import com.jeomo.sys.entity.UserRole;
import com.jeomo.sys.service.IUserRoleService;
import com.jeomo.sys.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户-角色关系表 服务实现类
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
