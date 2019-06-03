package com.jeomo.sys.mapper;

import com.jeomo.common.mapper.IBaseMapper;
import com.jeomo.sys.entity.RoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 角色-菜单对照表 Mapper 接口
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
@Mapper
public interface RoleMenuMapper extends IBaseMapper<RoleMenu> {


}
