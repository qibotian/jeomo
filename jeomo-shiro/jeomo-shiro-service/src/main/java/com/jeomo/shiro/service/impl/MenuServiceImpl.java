package com.jeomo.shiro.service.impl;

import com.jeomo.common.service.impl.BaseServiceImpl;
import com.jeomo.common.util.BeanCopyUtil;
import com.jeomo.shiro.dto.MenuDto;
import com.jeomo.shiro.entity.Menu;
import com.jeomo.shiro.mapper.MenuMapper;
import com.jeomo.shiro.service.IMenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单 服务实现类
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Override
    public List<MenuDto> listAllChildren(String parentCode) {
        List<Menu> menus = this.baseMapper.queryByParentCode(parentCode);
        if(menus != null) {
            menus.forEach(menu -> {
                menu.setChildren(this.baseMapper.queryByParentCode(menu.getCode()));
            });
        }
        return coverMenu2Dto(menus);
    }

    private List<MenuDto> coverMenu2Dto(List<Menu> menus) {
    	List<MenuDto> dots = new ArrayList<>();
    	if(menus != null) {
    		return BeanCopyUtil.copyListProperties(menus, MenuDto::new);
    	}
    	return dots;
    }

}
