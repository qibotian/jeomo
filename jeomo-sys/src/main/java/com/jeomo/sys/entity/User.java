package com.jeomo.sys.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

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
@TableName("sys_user")
public class User extends SysBaseEntity {

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
    private List<Role> roles = new ArrayList<>();

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getMallCode() {
        return mallCode;
    }

    public void setMallCode(String mallCode) {
        this.mallCode = mallCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
