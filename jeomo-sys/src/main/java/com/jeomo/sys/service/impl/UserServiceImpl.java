package com.jeomo.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jeomo.common.service.impl.BaseServiceImpl;
import com.jeomo.common.util.StringUtils;
import com.jeomo.sys.entity.User;
import com.jeomo.sys.mapper.UserMapper;
import com.jeomo.sys.service.IUserService;
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
    public User findUserByLoginName(String name) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.camelToUnderline("name"), name);
        return this.baseMapper.selectOne(wrapper);
    }

}
