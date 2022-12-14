package com.revature.sylvester.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.sylvester.dtos.requests.NewUserRequest;
import com.revature.sylvester.entities.User;
import com.revature.sylvester.services.TokenService;
import com.revature.sylvester.services.UserService;
import com.revature.sylvester.utils.custom_exceptions.InvalidAuthException;
import com.revature.sylvester.utils.custom_exceptions.InvalidUserException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final TokenService tokenService;

    public UserController(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @PostMapping
    public User signup(@RequestBody NewUserRequest req) {
        User createdUser;

        if(userService.isValidUsername(req.getUsername())) {
            if(!userService.isDuplicateUsername(req.getUsername())) {
                if(userService.isValidPassword(req.getPassword1())) {
                    if(userService.isSamePassword(req.getPassword1(), req.getPassword2())) {
                        if(userService.isValidEmail(req.getEmail())) {
                            if(!userService.isDuplicateEmail(req.getEmail()))
                                createdUser = userService.signup(req);
                            else
                                throw new InvalidUserException("Email address is already taken");
                        } else
                            throw new InvalidUserException("Invalid email address");
                    } else
                        throw new InvalidUserException("Passwords do not match");
                } else
                    throw new InvalidUserException("Invalid password");
            } else
                throw new InvalidUserException("Username is already taken");
        } else
            throw new InvalidUserException("Invalid username");

        return createdUser;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(InvalidUserException.class)
    public InvalidUserException handledUserException (InvalidUserException e) {
        return e;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(InvalidAuthException.class)
    public InvalidAuthException handledAuthException (InvalidAuthException e) {
        return e;
    }
}
