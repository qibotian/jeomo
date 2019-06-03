package com.jeomo.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jeomo.common.consts.SearchParam;
import com.jeomo.common.service.impl.BaseServiceImpl;
import com.jeomo.common.util.StringUtils;
import com.jeomo.sys.entity.UserRole;
import com.jeomo.sys.service.IUserRoleService;
import com.jeomo.sys.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
    public void deleteByUserId(Long userId) {
        Wrapper<UserRole> wrapper = new QueryWrapper<>();
        ((QueryWrapper<UserRole>) wrapper).eq("user_id", userId);
        userRoleMapper.delete(wrapper);
    }

    @Override
    public void deleteByUserIds(Long[] userIds) {
        Wrapper<UserRole> wrapper = new QueryWrapper<>();
        ((QueryWrapper<UserRole>) wrapper).in("user_id",userIds);
        userRoleMapper.delete(wrapper);
    }


    @Override
    public void insertUserRole(Long userId, Long[] roleIds) {
        List<UserRole> userRoles = Arrays.stream(roleIds).parallel().map(roleId -> {
            return new UserRole(userId, roleId);
        }).collect(Collectors.toList());
        saveBatch(userRoles);
    }

    @Override
    public void insertUserRoles(Long[] userIds, Long[] roleIds) {
        List<UserRole> userRoles = new ArrayList<>();
        Arrays.stream(userIds).forEach(userId -> {
            userRoles.addAll(Arrays.stream(roleIds).parallel().map(roleId -> {
                return new UserRole(userId, roleId);
            }).collect(Collectors.toList()));
        });
        deleteByUserIds(userIds);
        saveBatch(userRoles);
    }
}
