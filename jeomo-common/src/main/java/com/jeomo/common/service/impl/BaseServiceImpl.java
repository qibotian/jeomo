package com.jeomo.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jeomo.common.service.IBaseService;
import com.jeomo.common.vo.DataTable;

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
        page = page(page, null);
        dt.setTotal(page.getTotal());
        dt.setData(page.getRecords());
        return dt;
    }

}
