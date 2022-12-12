package com.revature.sylvester.controllers;

import com.revature.sylvester.entities.User;
import com.revature.sylvester.services.TokenService;
import com.revature.sylvester.services.UserService;
import com.revature.sylvester.utils.custom_exceptions.InvalidAuthException;
import com.revature.sylvester.utils.custom_exceptions.InvalidUserException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;
    private final TokenService tokenService;

    public UserController(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
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
