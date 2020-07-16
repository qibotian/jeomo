package com.jeomo.common.service.impl;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jeomo.common.consts.SearchParam;
import com.jeomo.common.consts.Sort;
import com.jeomo.common.dto.PageResponseDto;
import com.jeomo.common.query.PageQuery;
import com.jeomo.common.service.IBaseService;
import com.jeomo.common.util.StringUtils;

/**
 * @Author: qbt
 * @Date: 2019/3/21 19:34
 * @Version1.0
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl <M, T> implements IBaseService<T> {

    @Override
    public PageResponseDto pageSearch(PageQuery dt) {
        IPage<T> page = new Page<T>(dt.getPageNumber(), dt.getPageSize());
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        loadSearchParams(wrapper, dt.getSearchParams());
        loadSorts(wrapper, dt.getSorts());
        page = page(page, wrapper);
        return PageResponseDto.builder().total(page.getTotal()).items(page.getRecords()).build();
    }


    public void loadSorts(QueryWrapper<T> wrapper, Map<String, String> sorts) {
        if(null != sorts) {
            sorts.forEach((k,v) -> {
                String fieldName = StringUtils.camelToUnderline(k);
                if(Sort.ASC.equals(v.toLowerCase())) {
                    wrapper.orderByAsc(fieldName);
                } else {
                    wrapper.orderByDesc(fieldName);
                }
            });
        }
    }

    /**
     * 加载过滤条件
     * @param searchParams
     */
    public void loadSearchParams(QueryWrapper<T> wrapper, Map<String, Object> searchParams) {
        if(null != searchParams) {
            searchParams.forEach((name, value) -> {
                if(StringUtils.isEmpty(value)) {

                }else if(idLoadWrapper(SearchParam.SEARCH_EQ, name, value)) {
                    String fieldName = StringUtils.camelToUnderline(name.split(SearchParam.SEARCH_EQ)[1]);
                    wrapper.eq(fieldName, value);
                }else if(idLoadWrapper(SearchParam.SEARCH_GE, name, value)) {
                    String fieldName = StringUtils.camelToUnderline(name.split(SearchParam.SEARCH_GE)[1]);
                    wrapper.ge(fieldName, value);
                }else if(idLoadWrapper(SearchParam.SEARCH_LE, name, value)) {
                    String fieldName = StringUtils.camelToUnderline(name.split(SearchParam.SEARCH_LE)[1]);
                    wrapper.ge(fieldName, value);
                }else if(idLoadWrapper(SearchParam.SEARCH_LEFT_LIKE, name, value)) {
                    String fieldName = StringUtils.camelToUnderline(name.split(SearchParam.SEARCH_LEFT_LIKE)[1]);
                    wrapper.likeLeft(fieldName, value);
                }else if(idLoadWrapper(SearchParam.SEARCH_RIGHT_LIKE, name, value)) {
                    String fieldName = StringUtils.camelToUnderline(name.split(SearchParam.SEARCH_RIGHT_LIKE)[1]);
                    wrapper.likeRight(fieldName, value);
                }else if(idLoadWrapper(SearchParam.SEARCH_LIKE, name, value)) {
                    String fieldName = StringUtils.camelToUnderline(name.split(SearchParam.SEARCH_LIKE)[1]);
                    wrapper.like(fieldName, value);
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
