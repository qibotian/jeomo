package com.jeomo.mem.service.impl;

import com.jeomo.common.service.impl.BaseServiceImpl;
import com.jeomo.mem.entity.MemberCard;
import com.jeomo.mem.mapper.MemberCardMapper;
import com.jeomo.mem.service.IMemberCardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: qbt
 * @Date: 2020/6/30 15:27
 * @Version 1.0
 */
@Service
@Transactional
public class MemberCardServiceImpl extends BaseServiceImpl<MemberCardMapper, MemberCard> implements IMemberCardService {


}
