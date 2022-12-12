package com.revature.sylvester.models;

public class UserProfile {
    private String profile_id;
    private String display_name;
    private String location;
    private String birth_date;
    private String occupation;
    private String bio;
    private String user_id;

    public UserProfile(String profile_id, String display_name, String location, String birth_date, String occupation,
                       String bio, String user_id) {
        this.profile_id = profile_id;
        this.display_name = display_name;
        this.location = location;
        this.birth_date = birth_date;
        this.occupation = occupation;
        this.bio = bio;
        this.user_id = user_id;
    }

    public String getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(String profile_id) {
        this.profile_id = profile_id;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "profile_id='" + profile_id + '\'' +
                ", display_name='" + display_name + '\'' +
                ", location='" + location + '\'' +
                ", birth_date='" + birth_date + '\'' +
                ", occupation='" + occupation + '\'' +
                ", bio='" + bio + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
