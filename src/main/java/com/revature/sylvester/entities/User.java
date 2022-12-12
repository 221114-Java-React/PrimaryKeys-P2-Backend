package com.revature.sylvester.entities;

import javax.persistence.Entity;
import java.util.Date;

@Entity
//@Table(name = "users")
public class User {
    private String userId;
    private String username;
    private String password;
    private String email;
    private Date registered;
    private boolean isActive;
    private String roleId;

    public User(String userId, String username, String password, String email, Date registered, boolean isActive, String roleId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.registered = registered;
        this.isActive = isActive;
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", registered=" + registered +
                ", isActive=" + isActive +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
