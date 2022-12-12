package com.revature.sylvester.services;

import com.revature.sylvester.dtos.requests.NewLoginRequest;
import com.revature.sylvester.dtos.requests.NewUserRequest;
import com.revature.sylvester.dtos.responses.Principal;
import com.revature.sylvester.entities.User;
import com.revature.sylvester.entities.UserProfile;
import com.revature.sylvester.repositories.UserProfileRepository;
import com.revature.sylvester.repositories.UserRepository;
import com.revature.sylvester.utils.custom_exceptions.InvalidAuthException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User signup(NewUserRequest req) {
        User createdUser = new User(UUID.randomUUID().toString(), req.getUsername(), req.getPassword1(),
                req.getEmail(), new Date(), true, null);

        userRepo.save(createdUser);
        return createdUser;
    }

    public Principal login(NewLoginRequest req) {
        User validUser = userRepo.findByUsernameAndPassword(req.getUsername(), req.getPassword());

        if(validUser == null)
            throw new InvalidAuthException();

        return new Principal(validUser.getUserId(), validUser.getUsername(), validUser.getEmail(),
                validUser.getRegistered(), validUser.isActive(), validUser.getRoleId());
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepo.findAll();
    }

    public List<User> getAllUsersByUsername(String username) {
        return userRepo.findAllByUsername(username);
    }

    public boolean isValidUsername(String username) {
        return username.matches("/(^|[^@\\w])@(\\w{1,15})\\b/\n"); // conforms to Twitter's username specs
        // https://help.twitter.com/en/managing-your-account/twitter-username-rules#error
    }

    public boolean isDuplicateUsername(String username) {
        List<String> usernames = userRepo.findAllUsernames(username);
        return usernames.contains(username);
    }

    public boolean isValidPassword(String password) {
        return password.matches("/^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{10,}$/");
        // conforms to Twitter's password suggestions
        // https://help.twitter.com/en/safety-and-security/account-security-tips
    }

    public boolean isSamePassword(String password1, String password2) {
        return password1.equals(password2);
    }
}
