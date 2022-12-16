package com.revature.sylvester.services;

import com.revature.sylvester.dtos.requests.NewLoginRequest;
import com.revature.sylvester.dtos.requests.NewUserRequest;
import com.revature.sylvester.dtos.responses.Principal;
import com.revature.sylvester.entities.User;
import com.revature.sylvester.entities.UserProfile;
import com.revature.sylvester.repositories.UserProfileRepository;
import com.revature.sylvester.repositories.UserRepository;
import com.revature.sylvester.utils.custom_exceptions.InvalidAuthException;
import com.revature.sylvester.utils.custom_exceptions.InvalidProfileException;
import com.revature.sylvester.utils.custom_exceptions.InvalidUserException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void signup(NewUserRequest req) {
        User createdUser = new User(UUID.randomUUID().toString(), req.getUsername(), req.getPassword1(),
                req.getEmail(), new Date(), false, null);

        userRepo.save(createdUser);
    }

    public User activate(NewUserRequest req) {
        User activeUser = userRepo.findByUsernameAndPassword(req.getUsername(), req.getPassword1());
        if(!activeUser.isActive())
            activeUser.setActive(true);
        else
            throw new InvalidProfileException("User already has a profile");
        return activeUser;
    }

    public Principal login(NewLoginRequest req) {
        if(req.getUsername().isEmpty()||req.getPassword().isEmpty()){
            throw new InvalidAuthException("Please enter a username and password");
        }
        User validUser = userRepo.findByUsernameAndPassword(req.getUsername(), req.getPassword());

        if(validUser == null)
            throw new InvalidAuthException("Incorrect username or password");

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
        return username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$");
    }

    public boolean isDuplicateUsername(String username) {
        List<String> usernames = userRepo.findAllUsernames();
        return usernames.contains(username);
    }

    public boolean isValidPassword(String password) {
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
    }

    public boolean isSamePassword(String password1, String password2) {
        return password1.equals(password2);
    }

    public boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*$");
    }

    public boolean isDuplicateEmail(String email) {
        List<String> emails = userRepo.findAllEmails();
        return emails.contains(email);
    }
}
