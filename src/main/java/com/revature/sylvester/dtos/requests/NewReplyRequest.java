package com.revature.sylvester.dtos.requests;

public class NewReplyRequest {
    private String reply;
    private String postId;

    public NewReplyRequest(String reply, String postId) {
        this.reply = reply;
        this.postId = postId;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "NewCommentRequest{" +
                "reply='" + reply + '\'' +
                ", postId='" + postId + '\'' +
                '}';
    }
}
