package com.revature.sylvester.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "replies")
public class Comment {
    @Id
    private String replyId;

    @Column(name = "reply", nullable = false)
    private String reply;

    @Column(name = "replied", nullable = false)
    private Date replied;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(
            name = "post_id",
            nullable = false
    )
    @JsonBackReference
    private Post post;

    public Comment(String replyId, String reply, Date replied, User user, Post post) {
        this.replyId = replyId;
        this.reply = reply;
        this.replied = replied;
        this.user = user;
        this.post = post;
    }

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Date getReplied() {
        return replied;
    }

    public void setReplied(Date replied) {
        this.replied = replied;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "replyId='" + replyId + '\'' +
                ", reply='" + reply + '\'' +
                ", replied='" + replied + '\'' +
                ", user=" + user +
                ", post=" + post +
                '}';
    }
}
