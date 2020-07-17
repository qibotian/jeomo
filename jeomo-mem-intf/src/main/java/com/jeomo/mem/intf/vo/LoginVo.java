package com.jeomo.mem.intf.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * @Author: qbt
 * @Date: 2020/2/28 12:24
 * @Version 1.0
 */
@Data
public class LoginVo implements Serializable {

    /**
     * 会员手机号
     */
    private String phone;

    /**
     * 会员密码
     */
    private String password;

    /**
     * 购物中心编号
     */
    private String mall;

}
