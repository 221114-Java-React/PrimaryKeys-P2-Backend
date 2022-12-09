package com.revature.sylvester.models;

import java.util.Date;

public class Post {
    private String post_id;
    private Date posted;
    private String content;
    private String img_url;
    private String user_id;

    public Post(String post_id, Date posted, String content, String img_url, String user_id) {
        this.post_id = post_id;
        this.posted = posted;
        this.content = content;
        this.img_url = img_url;
        this.user_id = user_id;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public Date getPosted() {
        return posted;
    }

    public void setPosted(Date posted) {
        this.posted = posted;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "post_id='" + post_id + '\'' +
                ", posted=" + posted +
                ", content='" + content + '\'' +
                ", img_url='" + img_url + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
