package com.jeomo.sys.service.impl;

import com.jeomo.common.service.impl.BaseServiceImpl;
import com.jeomo.sys.entity.Menu;
import com.jeomo.sys.service.IMenuService;
import com.jeomo.sys.mapper.MenuMapper;
import org.springframework.stereotype.Service;

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

    private final static long TOP_MENU_ID = 0L;

    @Override
    public List<Menu> list() {
        return listAllChildren(TOP_MENU_ID);
    }

    @Override
    public List<Menu> listAllChildren(Long parentId) {
        List<Menu> menus = this.baseMapper.selectByParentId(parentId);
        if(menus != null) {
            menus.forEach(menu -> {
                System.out.println(menu);
                menu.setChildren(listAllChildren(menu.getId()));
            });
        }
        return menus;
    }

    @Override
    public List<Menu> selectLikeByLabel(String label) {
        return baseMapper.selectLikeByLabel(label);
    }

}
