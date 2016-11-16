package com.xin.model;

import javax.persistence.*;

/**
 * User: Xin
 * Date: 14-5-4
 * Time: 下午10:27
 */
@Entity
public class User {

    public User() {
    }

    public User(Long userId, String userName, String userEmail, String userQq, String password, Integer userStatus) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userQq = userQq;
        this.password = password;
        this.userStatus = userStatus;
    }

    private Long userId;

    @javax.persistence.Column(name = "user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    private String userName;

    @javax.persistence.Column(name = "user_name")
    @Basic
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userEmail;

    @javax.persistence.Column(name = "user_email")
    @Basic
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    private String userQq;

    @javax.persistence.Column(name = "user_qq")
    @Basic
    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }

    private String password;

    @javax.persistence.Column(name = "password")
    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Integer userStatus;

    @javax.persistence.Column(name = "user_status")
    @Basic
    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }


}
