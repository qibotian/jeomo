package com.jeomo.sys.service.impl;

import org.springframework.stereotype.Service;

import com.jeomo.common.service.impl.BaseServiceImpl;
import com.jeomo.common.util.BeanCopyUtil;
import com.jeomo.sys.dto.UserDto;
import com.jeomo.sys.entity.User;
import com.jeomo.sys.mapper.UserMapper;
import com.jeomo.sys.service.IUserService;

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
    public UserDto findByUsername(String username) {
    	User user = this.baseMapper.queryByUsername(username);
        return coverUser2Dto(user);
    }
    
    
    @Override
    public int removeByUsername(String username) {
    	return baseMapper.removeByUsername(username);
    }

    private UserDto coverUser2Dto(User user) {
    	UserDto dto = new UserDto();
    	BeanCopyUtil.copyProperties(user, dto);
		return dto;
    }
    
    
}
