package com.revature.sylvester.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "user_profiles")
public class UserProfile {
    @Id
    private String profileId;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "location")
    private String location;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "bio")
    private String bio;

    @OneToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    @JsonBackReference // child
    private String userId;

    public UserProfile() {
        super();
    }

    public UserProfile(String profileId, String displayName, String location, String birthDate, String occupation,
                       String bio) {
        this.profileId = profileId;
        this.displayName = displayName;
        this.location = location;
        this.birthDate = birthDate;
        this.occupation = occupation;
        this.bio = bio;
    }

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
