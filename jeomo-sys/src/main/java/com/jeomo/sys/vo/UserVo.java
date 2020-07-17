package com.jeomo.sys.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 *	系统用户
 *	用户应是组织隔离的
 *	但是用户名应当唯一，可以使用业务规定用户名唯一，比如使用企业邮箱等作为用户名
 *
 * </p>
 * @author jeomo
 * @since 2019-03-22
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sys_user")
public class UserVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所属组织
     */
    private String orgCode;
    
    /**
     * 所属购物中心
     */
    private String mallCode;
    
    /**
     * 用户名/登录名
     */
    private String username;
    
    /**
     * 用户姓名，昵称
     */
    private String nickname;

    /**
     * 用户密码
     */
    private transient String password;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 最后访问时间
     */
    private Date lastAccessTime;
    
    /**
     * 角色
     */
    @TableField(exist = false)
    private List<RoleVo> roles = new ArrayList<>();


}
