package com.jeomo.sys.mapper;

import com.jeomo.common.mapper.IBaseMapper;
import com.jeomo.sys.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户-角色关系表 Mapper 接口
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
@Mapper
public interface UserRoleMapper extends IBaseMapper<UserRole> {

}
