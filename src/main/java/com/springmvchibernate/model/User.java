package com.springmvchibernate.model;

import javax.persistence.*;

/**
 * 用户表
 */
@Entity
public class User {

    public User() {
    }

    /**
     *
     * @param userId 用户Id
     * @param userName  用户名
     * @param userEmail 邮箱
     * @param userQq qq
     * @param password 密码
     * @param userStatus 状态
     */
    public User(Long userId, String userName, String userEmail, String userQq, String password, Integer userStatus) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userQq = userQq;
        this.password = password;
        this.userStatus = userStatus;
    }

    private Long userId;

    @Column(name = "user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    private String userName;

    @Column(name = "user_name")
    @Basic
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userEmail;

    @Column(name = "user_email")
    @Basic
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    private String userQq;

    @Column(name = "user_qq")
    @Basic
    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }

    private String password;

    @Column(name = "password")
    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Integer userStatus;

    @Column(name = "user_status")
    @Basic
    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }


}
