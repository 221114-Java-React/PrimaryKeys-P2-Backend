package com.revature.sylvester.services;

import com.revature.sylvester.dtos.requests.NewUserRequest;
import com.revature.sylvester.entities.UserProfile;
import com.revature.sylvester.repositories.UserProfileRepository;
import com.revature.sylvester.repositories.UserRepository;
import com.revature.sylvester.utils.custom_exceptions.InvalidUserException;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
                req.getBirthDate(), null, null);

        createdProfile.setUser(userRepo.findByUsernameAndPassword(req.getUsername(), req.getPassword1()));
        profileRepo.save(createdProfile);
        return createdProfile;
    }

    public boolean isEmptyDisplayName(String displayName) {
        return displayName.isEmpty();
    }

    public boolean isValidBirthDate(String birthDateStr) {
        Date birthDate = null;
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        formatter.setLenient(false);
        try {
            birthDate = formatter.parse(birthDateStr);
        } catch (ParseException e) {
            throw new InvalidUserException(e);
        }
        return true;
    }
}
