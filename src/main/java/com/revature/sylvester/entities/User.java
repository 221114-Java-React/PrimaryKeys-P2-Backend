package com.revature.sylvester.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "registered")
    private Date registered;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "role_id")
    private String roleId;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "user"
    )
    @JsonManagedReference // parent
    private UserProfile profile;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user"
    )
    @JsonManagedReference // parent
    private List<Post> posts;

    public User() {
        super();
    }

    public User(String userId, String username, String password, String email, Date registered, boolean isActive,
                String roleId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.registered = registered;
        this.isActive = isActive;
        this.roleId = roleId;
    }

    public User(String userId, String username, String password, String email, Date registered, boolean isActive,
                String roleId, UserProfile profile) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.registered = registered;
        this.isActive = isActive;
        this.roleId = roleId;
        this.profile = profile;
    }

    public User(String userId, String username, String password, String email, Date registered, boolean isActive,
                String roleId, List<Post> posts) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.registered = registered;
        this.isActive = isActive;
        this.roleId = roleId;
        this.posts = posts;
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
