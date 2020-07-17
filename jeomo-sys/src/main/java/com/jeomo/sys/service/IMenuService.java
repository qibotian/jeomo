package com.jeomo.sys.service;

import com.jeomo.common.service.IBaseService;
import com.jeomo.sys.dto.MenuDto;
import com.jeomo.sys.entity.Menu;

import java.util.List;

/**
 * <p>
 * 菜单 服务类
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
public interface IMenuService extends IBaseService<Menu> {

    /**
     * 查询所有子菜单
     * @param parentId 父节点ID
     * @return
     */
    List<MenuDto> listAllChildren(String parentId);

}
