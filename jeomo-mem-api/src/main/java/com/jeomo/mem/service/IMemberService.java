package com.jeomo.mem.service;

import com.jeomo.common.service.IBaseService;
import com.jeomo.mem.entity.Member;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author jeomo
 * @since 2019-03-22
 */
public interface IMemberService extends IBaseService<Member> {

    /**
     * 测试方法
     */
    String sayHi();

    /**
     * 测试实体类
     * @param id
     * @return
     */
    Member testGetById(Long id);
}
