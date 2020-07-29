package com.jeomo.shiro.service.impl;

import com.jeomo.common.service.impl.BaseServiceImpl;
import com.jeomo.common.util.BeanCopyUtil;
import com.jeomo.shiro.dto.RoleDto;
import com.jeomo.shiro.dto.UserDto;
import com.jeomo.shiro.entity.User;
import com.jeomo.shiro.mapper.UserMapper;
import com.jeomo.shiro.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public UserDto queryByUsername(String username) {
    	User user = this.baseMapper.queryByUsername(username);
        return coverUser2Dto(user);
    }

    @Override
    public UserDto queryAllInfoByUsername(String username) {
        User user = this.baseMapper.queryAllInfoByUsername(username);
         return coverUser2Dto(user);
    }

    @Override
    public int removeByUsername(String username) {
    	return baseMapper.removeByUsername(username);
    }

    private UserDto coverUser2Dto(User user) {
        if(user == null) return null;
    	UserDto dto = new UserDto();
    	BeanCopyUtil.copyProperties(user, dto);
    	dto.setRoles(BeanCopyUtil.copyListProperties(user.getRoles(), RoleDto::new));
		return dto;
    }
}
