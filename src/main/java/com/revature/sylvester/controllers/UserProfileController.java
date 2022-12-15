package com.revature.sylvester.controllers;

import com.revature.sylvester.dtos.requests.NewUserRequest;
import com.revature.sylvester.entities.User;
import com.revature.sylvester.entities.UserProfile;
import com.revature.sylvester.services.UserProfileService;
import com.revature.sylvester.services.UserService;
import com.revature.sylvester.utils.custom_exceptions.InvalidUserException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/profiles")
public class UserProfileController {
    private final UserProfileService profileService;
    private final UserService userService;

    public UserProfileController(UserProfileService profileService, UserService userService) {
        this.profileService = profileService;
        this.userService = userService;
    }

    @PostMapping
    public UserProfile create(@RequestBody NewUserRequest req) {
        UserProfile createdProfile;
        User user;

        if(!profileService.isEmptyDisplayName(req.getDisplayName())) {
            if(profileService.isValidBirthDate(req.getBirthDate())) {
                user = userService.activate(req);
                createdProfile = profileService.createProfile(req, user);
            } else
                throw new InvalidUserException("Must be 13 years or older to sign up");
        } else
            throw new InvalidUserException("Please enter a display name");

        return createdProfile;
    }

    @GetMapping("/user")
    public UserProfile getByUserId(@RequestParam String id) {
        return profileService.getProfileByUserId(id);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(InvalidUserException.class)
    public InvalidUserException handledUserException (InvalidUserException e) {
        return e;
    }
}
