package com.revature.sylvester.services;

import com.revature.sylvester.dtos.requests.NewUserRequest;
import com.revature.sylvester.entities.UserProfile;
import com.revature.sylvester.repositories.UserProfileRepository;

import java.util.UUID;

public class UserProfileService {
    private final UserProfileRepository profileRepo;

    public UserProfileService(UserProfileRepository profileRepo) {
        this.profileRepo = profileRepo;
    }

    public UserProfile signup(NewUserRequest req) {
        UserProfile createdProfile = new UserProfile(UUID.randomUUID().toString(), req.getDisplayName(), null,
                req.getBirthDate(), null, null);

        profileRepo.save(createdProfile);
        return createdProfile;
    }
}
