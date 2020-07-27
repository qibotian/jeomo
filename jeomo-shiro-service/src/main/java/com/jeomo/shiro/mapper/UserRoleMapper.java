package com.jeomo.shiro.mapper;

import com.jeomo.common.mapper.IBaseMapper;
import com.jeomo.shiro.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 用户-角色关系表 Mapper 接口
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
@Mapper
@Component
public interface UserRoleMapper extends IBaseMapper<UserRole> {

}
