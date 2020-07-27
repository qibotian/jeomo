package com.jeomo.shiro.service.impl;

import com.jeomo.common.service.impl.BaseServiceImpl;
import com.jeomo.shiro.entity.RoleMenu;
import com.jeomo.shiro.mapper.RoleMenuMapper;
import com.jeomo.shiro.service.IRoleMenuService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色-菜单对照表 服务实现类
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
@Service
public class RoleMenuServiceImpl extends BaseServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

}
