package com.jeomo.mem.service.impl;

import com.jeomo.mem.service.IMemberLevelService;
import org.springframework.stereotype.Service;

/**
 * @Author: qbt
 * @Date: 2020/5/8 20:10
 * @Version 1.0
 */
@Service
public class MemberLevelServiceImpl implements IMemberLevelService {

    @Override
    public Long queryDefaultMemberLevel() {
        return 1L;
    }
}
