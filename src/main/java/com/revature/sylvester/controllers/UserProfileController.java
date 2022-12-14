package com.revature.sylvester.controllers;

import com.revature.sylvester.dtos.requests.NewUserRequest;
import com.revature.sylvester.entities.UserProfile;
import com.revature.sylvester.services.UserProfileService;
import com.revature.sylvester.utils.custom_exceptions.InvalidUserException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/profiles")
public class UserProfileController {
    private final UserProfileService profileService;

    public UserProfileController(UserProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public UserProfile signup(@RequestBody NewUserRequest req) {
        UserProfile createdProfile;

        if(!profileService.isEmptyDisplayName(req.getDisplayName())) {
            if(profileService.isValidBirthDate(req.getBirthDate()))
                createdProfile = profileService.signup(req);
            else
                throw new InvalidUserException("Must be 13 years or older to sign up");
        } else
            throw new InvalidUserException("Please enter a display name");

        return createdProfile;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(InvalidUserException.class)
    public InvalidUserException handledUserException (InvalidUserException e) {
        return e;
    }
}
