package com.jeomo.sys.service;

import com.jeomo.common.service.IBaseService;
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
    List<Menu> listAllChildren(Long parentId);

    /**
     * 根据babel相似查询
     * @param label
     * @return
     */
    List<Menu> selectLikeByLabel(String label);

}
