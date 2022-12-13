package com.revature.sylvester.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

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
    private Date birthDate;

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
    private User user;

    public UserProfile() {
        super();
    }

    public UserProfile(String profileId, String displayName, String location, Date birthDate, String occupation,
                       String bio) {
        this.profileId = profileId;
        this.displayName = displayName;
        this.location = location;
        this.birthDate = birthDate;
        this.occupation = occupation;
        this.bio = bio;
    }

    public UserProfile(String profileId, String displayName, String location, Date birthDate, String occupation,
                       String bio, User user) {
        this.profileId = profileId;
        this.displayName = displayName;
        this.location = location;
        this.birthDate = birthDate;
        this.occupation = occupation;
        this.bio = bio;
        this.user = user;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
                ", user=" + user +
                '}';
    }
}
