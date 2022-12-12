package com.revature.sylvester.models;

import java.util.Date;

public class Repost {
    private Date reposted;
    private String repost_id;
    private String user_id;
    private String post_id;

    public Repost(Date reposted, String repost_id, String user_id, String post_id) {
        this.reposted = reposted;
        this.repost_id = repost_id;
        this.user_id = user_id;
        this.post_id = post_id;
    }

    public Date getReposted() {
        return reposted;
    }

    public void setReposted(Date reposted) {
        this.reposted = reposted;
    }

    public String getRepost_id() {
        return repost_id;
    }

    public void setRepost_id(String repost_id) {
        this.repost_id = repost_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    @Override
    public String toString() {
        return "Repost{" +
                "reposted=" + reposted +
                ", repost_id='" + repost_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", post_id='" + post_id + '\'' +
                '}';
    }
}
