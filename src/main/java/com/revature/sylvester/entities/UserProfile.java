package com.revature.sylvester.entities;

public class UserProfile {
    private String profileId;
    private String displayName;
    private String location;
    private String birthDate;
    private String occupation;
    private String bio;
    private String userId;

    public UserProfile(String profileId, String displayName, String location, String birthDate, String occupation,
                       String bio, String userId) {
        this.profileId = profileId;
        this.displayName = displayName;
        this.location = location;
        this.birthDate = birthDate;
        this.occupation = occupation;
        this.bio = bio;
        this.userId = userId;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "profileId='" + profileId + '\'' +
                ", displayName='" + displayName + '\'' +
                ", location='" + location + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", occupation='" + occupation + '\'' +
                ", bio='" + bio + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
