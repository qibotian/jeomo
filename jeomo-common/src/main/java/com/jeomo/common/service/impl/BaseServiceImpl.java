package com.jeomo.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jeomo.common.consts.SearchParam;
import com.jeomo.common.service.IBaseService;
import com.jeomo.common.vo.DataTable;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @Author: qbt
 * @Date: 2019/3/21 19:34
 * @Version1.0
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl <M, T> implements IBaseService<T> {

    @Override
    public DataTable<T> pageSearch(DataTable<T> dt) {
        IPage<T> page = new Page<T>(dt.getPageNumber(), dt.getPageSize());
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        loadSearchParams(wrapper, dt.getSearchParams());
        page = page(page, wrapper);
        dt.setTotal(page.getTotal());
        dt.setItems(page.getRecords());
        return dt;
    }

    /**
     * 加载过滤条件
     * @param searchParams
     */
    private void loadSearchParams(QueryWrapper<T> wrapper, Map<String, Object> searchParams) {
        if(null != searchParams) {
            searchParams.forEach((name, value) -> {
                if(idLoadWrapper(SearchParam.SEARCH_EQ, name, value)) {
                    wrapper.eq(name.split(SearchParam.SEARCH_EQ)[1], value);
                } else if(idLoadWrapper(SearchParam.SEARCH_GE, name, value)) {
                    wrapper.ge(name.split(SearchParam.SEARCH_GE)[1], value);
                }else if(idLoadWrapper(SearchParam.SEARCH_LE, name, value)) {
                    wrapper.ge(name.split(SearchParam.SEARCH_LE)[1], value);
                }else if(idLoadWrapper(SearchParam.SEARCH_LEFT_LIKE, name, value)) {
                    wrapper.likeLeft(name.split(SearchParam.SEARCH_LEFT_LIKE)[1], value);
                }else if(idLoadWrapper(SearchParam.SEARCH_RIGHT_LIKE, name, value)) {
                    wrapper.likeRight(name.split(SearchParam.SEARCH_RIGHT_LIKE)[1], value);
                }else if(idLoadWrapper(SearchParam.SEARCH_LIKE, name, value)) {
                    wrapper.like(name.split(SearchParam.SEARCH_LIKE)[1], value);
                }
            });
        }
    }

    /**
     * 判断是否加载条件
     * @param searchCnd
     * @param name
     * @param value
     * @return
     */
    private boolean idLoadWrapper(String searchCnd, String name, Object value) {
        return !StringUtils.isEmpty(name) && value != null && name.startsWith(searchCnd);
    }

}
