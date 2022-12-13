package com.revature.sylvester.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.sylvester.dtos.requests.NewUserRequest;
import com.revature.sylvester.entities.UserProfile;
import com.revature.sylvester.services.UserProfileService;
import com.revature.sylvester.utils.custom_exceptions.InvalidUserException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
public class UserProfileController {
    private final UserProfileService profileService;
    private final ObjectMapper mapper;

    public UserProfileController(UserProfileService profileService, ObjectMapper mapper) {
        this.profileService = profileService;
        this.mapper = mapper;
    }

    @PostMapping
    public UserProfile signup(@RequestBody NewUserRequest req) {
        UserProfile createdProfile;

        createdProfile = profileService.signup(req);

        return createdProfile;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(InvalidUserException.class)
    public InvalidUserException handledUserException (InvalidUserException e) {
        return e;
    }
}
