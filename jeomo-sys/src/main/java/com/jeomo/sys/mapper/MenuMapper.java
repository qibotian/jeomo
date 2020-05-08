package com.jeomo.sys.mapper;

import com.jeomo.common.mapper.IBaseMapper;
import com.jeomo.sys.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 菜单 Mapper 接口
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
@Mapper
public interface MenuMapper extends IBaseMapper<Menu> {

    /**
     * 根据父节点id查询子节点
     * @param parentId
     * @return
     */
    List<Menu> selectByParentId(Long parentId);

    /**
     * 根据label查询
     * @param label
     * @return
     */
    List<Menu> selectLikeByLabel(String label);

}
