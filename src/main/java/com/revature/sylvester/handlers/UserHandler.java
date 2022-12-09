package com.revature.sylvester.handlers;

import com.revature.sylvester.services.UserService;

public class UserHandler {
    private final UserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }
}
