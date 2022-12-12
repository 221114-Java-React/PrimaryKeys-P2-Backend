package com.revature.sylvester.models;

public class Hashtag {
    private String hashtag_id;
    private String hashtag;
    private String post_id;

    public Hashtag(String hashtag_id, String hashtag, String post_id) {
        this.hashtag_id = hashtag_id;
        this.hashtag = hashtag;
        this.post_id = post_id;
    }

    public String getHashtag_id() {
        return hashtag_id;
    }

    public void setHashtag_id(String hashtag_id) {
        this.hashtag_id = hashtag_id;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    @Override
    public String toString() {
        return "Hashtag{" +
                "hashtag_id='" + hashtag_id + '\'' +
                ", hashtag='" + hashtag + '\'' +
                ", post_id='" + post_id + '\'' +
                '}';
    }
}
