package com.jeomo.mem.service;

/**
 * 会员级别
 * @Author: qbt
 * @Date: 2020/5/8 20:08
 * @Version 1.0
 */
public interface IMemberLevelService {

    /**
     * 获取默认的会员级别
     * @return
     */
	Long queryDefaultMemberLevel();

}
