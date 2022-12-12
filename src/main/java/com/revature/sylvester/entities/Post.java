package com.revature.sylvester.entities;

import java.util.Date;

public class Post {
    private String postId;
    private Date posted;
    private String content;
    private String imgUrl;
    private String userId;

    public Post(String postId, Date posted, String content, String imgUrl, String userId) {
        this.postId = postId;
        this.posted = posted;
        this.content = content;
        this.imgUrl = imgUrl;
        this.userId = userId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId='" + postId + '\'' +
                ", posted=" + posted +
                ", content='" + content + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
