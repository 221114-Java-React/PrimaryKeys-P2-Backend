package com.revature.sylvester.models;

import java.util.Date;

public class FollowingRelationship {
    private String relationship_id;
    private Date followed;
    private String user_id;
    private String following_id;

    public FollowingRelationship(String relationship_id, Date followed, String user_id, String following_id) {
        this.relationship_id = relationship_id;
        this.followed = followed;
        this.user_id = user_id;
        this.following_id = following_id;
    }

    public String getRelationship_id() {
        return relationship_id;
    }

    public void setRelationship_id(String relationship_id) {
        this.relationship_id = relationship_id;
    }

    public Date getFollowed() {
        return followed;
    }

    public void setFollowed(Date followed) {
        this.followed = followed;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFollowing_id() {
        return following_id;
    }

    public void setFollowing_id(String following_id) {
        this.following_id = following_id;
    }

    @Override
    public String toString() {
        return "FollowingRelationship{" +
                "relationship_id='" + relationship_id + '\'' +
                ", followed=" + followed +
                ", user_id='" + user_id + '\'' +
                ", following_id='" + following_id + '\'' +
                '}';
    }
}
