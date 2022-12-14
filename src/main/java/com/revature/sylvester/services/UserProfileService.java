package com.revature.sylvester.services;

import com.revature.sylvester.dtos.requests.NewUserRequest;
import com.revature.sylvester.entities.UserProfile;
import com.revature.sylvester.repositories.UserProfileRepository;
import com.revature.sylvester.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

@Service
public class UserProfileService {
    private final UserProfileRepository profileRepo;
    private final UserRepository userRepo;

    public UserProfileService(UserProfileRepository profileRepo, UserRepository userRepo) {
        this.profileRepo = profileRepo;
        this.userRepo = userRepo;
    }

    public UserProfile signup(NewUserRequest req) {
        UserProfile createdProfile = new UserProfile(UUID.randomUUID().toString(), req.getDisplayName(), null,
                req.getBirthDate(), null, null, null);

        createdProfile.setUser(userRepo.findByUsernameAndPassword(req.getUsername(), req.getPassword1()));
        profileRepo.save(createdProfile);
        return createdProfile;
    }

    public boolean isEmptyDisplayName(String displayName) {
        return displayName.isEmpty();
    }

    public boolean isValidBirthDate(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(birthDate, currentDate).getYears();

        return age > 13;
    }
}
