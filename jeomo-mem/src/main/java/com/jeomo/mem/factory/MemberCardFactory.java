package com.jeomo.mem.factory;

/**
 * @Author: qbt
 * @Date: 2020/5/8 20:14
 * @Version 1.0
 */
public class MemberCardFactory {

    /**
     * 生成一个新的会员卡号
     * @return
     */
    public static Long createMemberCard() {
        return System.currentTimeMillis();
    }


}
