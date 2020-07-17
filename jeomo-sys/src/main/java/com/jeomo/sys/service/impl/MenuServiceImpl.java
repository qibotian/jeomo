package com.jeomo.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jeomo.common.service.impl.BaseServiceImpl;
import com.jeomo.common.util.BeanCopyUtil;
import com.jeomo.sys.dto.MenuDto;
import com.jeomo.sys.entity.Menu;
import com.jeomo.sys.mapper.MenuMapper;
import com.jeomo.sys.service.IMenuService;

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
        return coverMenu2Dots(menus);
    }

    private List<MenuDto> coverMenu2Dots(List<Menu> menus) {
    	List<MenuDto> dots = new ArrayList<>();
    	if(menus != null) {
    		return BeanCopyUtil.copyListProperties(menus, MenuDto::new);
    	}
    	return dots;
    }

}
