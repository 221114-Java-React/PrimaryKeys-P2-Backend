package com.revature.sylvester;

import com.revature.sylvester.dtos.requests.NewLoginRequest;
import com.revature.sylvester.dtos.requests.NewUserRequest;
import com.revature.sylvester.dtos.responses.Principal;
import com.revature.sylvester.entities.User;
import com.revature.sylvester.repositories.UserRepository;
import com.revature.sylvester.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {
    private UserRepository userRepositorySut;
    private UserService userServiceSut;

    @Before
    public void init() {
        userRepositorySut = Mockito.mock(UserRepository.class);
        userServiceSut = new UserService(userRepositorySut);
    }

    @Test
    public void test_correctSignup_givenRequest() {
        // Arrange
        UserService sut = Mockito.spy(userServiceSut);
        NewUserRequest req = new NewUserRequest("testUsername", "mRMEY476", "mRMEY476", "testUsername@testUsername.com", "testDisplayName", LocalDate.of(2022,12,13));
        User user = new User("0", "testUsername", "mRMEY476", "testUsername@testUsername.com", new Date(2022,12,13), true, null);

        Mockito.when(sut.signup(req)).thenReturn(user);

        // Act
        User newUser = sut.signup(req);

        // Assert
        assertEquals("0",newUser.getUserId());
        assertEquals("testUsername",newUser.getUsername());
        assertEquals("mRMEY476",newUser.getPassword());
        assertEquals("testUsername@testUsername.com",newUser.getEmail());
        assertEquals(new Date(2022,12,13),newUser.getRegistered());
        assertEquals(null,newUser.getRoleId());
    }

    @Test
    public void test_correctLogin_givenRequest() {
        // Arrange
        UserService sut1 = Mockito.spy(userServiceSut);
        UserRepository sut2 = Mockito.spy(userRepositorySut);
        NewLoginRequest req = new NewLoginRequest("testUsername", "mRMEY476");
        User user = new User("0", "testUsername", "mRMEY476", "testUsername@testUsername.com", new Date(2022,12,13), true, null);
        Principal principal = new Principal("0", "testUsername", "testUsername@testUsername.com", new Date(2022,12,13), true, null);

        Mockito.when(sut2.findByUsernameAndPassword(req.getUsername(), req.getPassword())).thenReturn(user);
        Mockito.when(sut1.login(req)).thenReturn(principal);

        // Act
        Principal newPrincipal = sut1.login(req);

        // Assert
        assertEquals("0",newPrincipal.getUserId());
        assertEquals("testUsername",newPrincipal.getUsername());
        assertEquals("testUsername@testUsername.com",newPrincipal.getEmail());
        assertEquals(new Date(2022,12,13),newPrincipal.getRegistered());
        assertEquals(null,newPrincipal.getRoleId());
    }

    @Test
    public void test_correctGetAllUsers_givenNothing() {
        // Arrange
        UserService sut = Mockito.spy(userServiceSut);
        User user1 = new User("0", "testUsername", "mRMEY476", "testUsername@testUsername.com", new Date(2022,12,13), true, null);
        User user2 = new User("1", "testUsername2", "mRMEY476", "testUsername2@testUsername2.com", new Date(2022,12,13), true, null);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        Mockito.when(sut.getAllUsers()).thenReturn(users);

        // Act
        List<User> newUsers = sut.getAllUsers();

        // Assert
        assertEquals(2, newUsers.size());

        User newUser = newUsers.get(0);

        assertEquals("0",newUser.getUserId());
        assertEquals("testUsername",newUser.getUsername());
        assertEquals("mRMEY476",newUser.getPassword());
        assertEquals("testUsername@testUsername.com",newUser.getEmail());
        assertEquals(new Date(2022,12,13),newUser.getRegistered());
        assertEquals(null,newUser.getRoleId());

        newUser = newUsers.get(1);

        assertEquals("1",newUser.getUserId());
        assertEquals("testUsername2",newUser.getUsername());
        assertEquals("mRMEY476",newUser.getPassword());
        assertEquals("testUsername2@testUsername2.com",newUser.getEmail());
        assertEquals(new Date(2022,12,13),newUser.getRegistered());
        assertEquals(null,newUser.getRoleId());
    }

    @Test
    public void test_correctGetAllUsersByUsername_givenUsername() {
        // Arrange
        UserService sut = Mockito.spy(userServiceSut);
        User user1 = new User("0", "testUsername", "mRMEY476", "testUsername@testUsername.com", new Date(2022,12,13), true, null);
        List<User> users = new ArrayList<>();
        users.add(user1);

        Mockito.when(sut.getAllUsersByUsername("testUsername")).thenReturn(users);

        // Act
        List<User> newUsers = sut.getAllUsersByUsername("testUsername");

        // Assert
        assertEquals(1, newUsers.size());

        User newUser = newUsers.get(0);

        assertEquals("0",newUser.getUserId());
        assertEquals("testUsername",newUser.getUsername());
        assertEquals("mRMEY476",newUser.getPassword());
        assertEquals("testUsername@testUsername.com",newUser.getEmail());
        assertEquals(new Date(2022,12,13),newUser.getRegistered());
        assertEquals(null,newUser.getRoleId());
    }

    @Test
    public void test_correctIsDuplicateUsername_givenUsername() {
        // Arrange
        UserService sut1 = Mockito.spy(userServiceSut);
        UserRepository sut2 = Mockito.spy(userRepositorySut);
        List<String> allUsernames = new ArrayList<>();
        allUsernames.add("testUsername");

        Mockito.when(sut2.findAllUsernames()).thenReturn(allUsernames);
        Mockito.when(sut1.isDuplicateUsername("testUsername")).thenReturn(true);
        Mockito.when(sut1.isDuplicateUsername("testUsername2")).thenReturn(false);

        // Act
        Boolean duplicateUsernameTrue = sut1.isDuplicateUsername("testUsername");
        Boolean duplicateUsernameFalse = sut1.isDuplicateUsername("testUsername2");

        // Assert
        assertEquals(true,duplicateUsernameTrue);
        assertEquals(false,duplicateUsernameFalse);
    }

    @Test
    public void test_correctIsSamePassword_givenPasswords() {
        // Arrange
        UserService sut = Mockito.spy(userServiceSut);

        // Act
        Boolean samePassword = userServiceSut.isSamePassword("mRMEY476","mRMEY476");

        // Assert
        assertEquals(true,samePassword);
    }

    @Test
    public void test_correctIsDuplicateEmail_givenEmail() {
        // Arrange
        UserService sut1 = Mockito.spy(userServiceSut);
        UserRepository sut2 = Mockito.spy(userRepositorySut);
        List<String> allEmails = new ArrayList<>();
        allEmails.add("testUsername@testUsername.com");

        Mockito.when(sut2.findAllEmails()).thenReturn(allEmails);
        Mockito.when(sut1.isDuplicateEmail("testUsername@testUsername.com")).thenReturn(true);
        Mockito.when(sut1.isDuplicateEmail("testUsername2@testUsername2.com")).thenReturn(false);

        // Act
        Boolean duplicateEmailTrue = sut1.isDuplicateEmail("testUsername@testUsername.com");
        Boolean duplicateEmailFalse = sut1.isDuplicateEmail("testUsername2@testUsername2.com");

        // Assert
        assertEquals(true,duplicateEmailTrue);
        assertEquals(false,duplicateEmailFalse);
    }
}
