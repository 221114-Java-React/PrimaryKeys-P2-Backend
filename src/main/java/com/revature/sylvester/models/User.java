package com.revature.sylvester.models;

import java.util.Date;

public class User {
    private String user_id;
    private String username;
    private String password;
    private String email;
    private Date registered;
    private boolean is_active;
    private String role_id;

    public User(String user_id, String username, String password, String email, Date registered, boolean is_active, String role_id) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.registered = registered;
        this.is_active = is_active;
        this.role_id = role_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", registered=" + registered +
                ", is_active=" + is_active +
                ", role_id='" + role_id + '\'' +
                '}';
    }
}
