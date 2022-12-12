package com.revature.sylvester.entities;

public class Like {
    private String likeId;
    private String userId;
    private String postId;

    public Like(String likeId, String userId, String postId) {
        this.likeId = likeId;
        this.userId = userId;
        this.postId = postId;
    }

    public String getLikeId() {
        return likeId;
    }

    public void setLikeId(String likeId) {
        this.likeId = likeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "Like{" +
                "likeId='" + likeId + '\'' +
                ", userId='" + userId + '\'' +
                ", postId='" + postId + '\'' +
                '}';
    }
}
