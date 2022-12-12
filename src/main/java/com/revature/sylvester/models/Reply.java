package com.revature.sylvester.models;

import java.util.Date;

public class Reply {
    private String reply_id;
    private Date replied;
    private String user_id;
    private String reply;

    public Reply(String reply_id, Date replied, String user_id, String reply) {
        this.reply_id = reply_id;
        this.replied = replied;
        this.user_id = user_id;
        this.reply = reply;
    }

    public String getReply_id() {
        return reply_id;
    }

    public void setReply_id(String reply_id) {
        this.reply_id = reply_id;
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
                "reply_id='" + reply_id + '\'' +
                ", replied=" + replied +
                ", user_id='" + user_id + '\'' +
                ", reply='" + reply + '\'' +
                '}';
    }
}
