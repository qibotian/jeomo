package com.jeomo.shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jeomo.common.service.impl.BaseServiceImpl;
import com.jeomo.shiro.entity.UserRole;
import com.jeomo.shiro.mapper.UserRoleMapper;
import com.jeomo.shiro.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public void deleteByUsername(String username) {
    	QueryWrapper<UserRole> wrapper = new QueryWrapper<UserRole>();
    	wrapper.eq("username", username);
        userRoleMapper.delete(wrapper);
    }

    @Override
    public void deleteByUsernames(String[] usernames) {
    	QueryWrapper<UserRole> wrapper = new QueryWrapper<>();
    	wrapper.in("username", Arrays.asList(usernames));
        userRoleMapper.delete(wrapper);
    }


    @Override
    public void insertUserRole(String username, String[] roleCodes) {
        List<UserRole> userRoles = Arrays.stream(roleCodes).parallel().map(roleCode -> {
            return new UserRole(username, roleCode);
        }).collect(Collectors.toList());
        saveBatch(userRoles);
    }

    @Override
    public void insertUserRoles(String[] usernames, String[] roleCodes) {
        List<UserRole> userRoles = new ArrayList<>();
        Arrays.stream(usernames).forEach(username -> {
            userRoles.addAll(Arrays.stream(roleCodes).parallel().map(roleCode -> {
                return new UserRole(username, roleCode);
            }).collect(Collectors.toList()));
        });
        deleteByUsernames(usernames);
        saveBatch(userRoles);
    }
}
