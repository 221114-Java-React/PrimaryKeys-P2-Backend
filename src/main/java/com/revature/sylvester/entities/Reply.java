package com.revature.sylvester.entities;

import java.util.Date;

public class Reply {
    private String replyId;
    private Date replied;
    private String user_id;
    private String reply;

    public Reply(String replyId, Date replied, String user_id, String reply) {
        this.replyId = replyId;
        this.replied = replied;
        this.user_id = user_id;
        this.reply = reply;
    }

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    public Date getReplied() {
        return replied;
    }

    public void setReplied(Date replied) {
        this.replied = replied;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "replyId='" + replyId + '\'' +
                ", replied=" + replied +
                ", user_id='" + user_id + '\'' +
                ", reply='" + reply + '\'' +
                '}';
    }
}
