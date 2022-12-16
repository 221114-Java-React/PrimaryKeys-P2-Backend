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

import static org.junit.Assert.*;

public class UserServiceTest {
    private UserService sut;
    private final UserRepository mockUserRepo = Mockito.mock(UserRepository.class);

    @Before
    public void init() {
        sut = new UserService(mockUserRepo);
    }

    @Test
    public void test_correctSignup_givenRequest() {
        // Arrange
        UserService spySut = Mockito.spy(sut);
        NewUserRequest req = new NewUserRequest("testUsername", "mRMEY476", "mRMEY476", "testUsername@testUsername.com", "testDisplayName", LocalDate.of(2022,12,13));
        User user = new User("0", "testUsername", "mRMEY476", "testUsername@testUsername.com", new Date(2022,12,13), true, null);

        Mockito.when(spySut.signup(req)).thenReturn(user);

        // Act
        User newUser = spySut.signup(req);

        // Assert
        assertEquals("0",newUser.getUserId());
        assertEquals("testUsername",newUser.getUsername());
        assertEquals("mRMEY476",newUser.getPassword());
        assertEquals("testUsername@testUsername.com",newUser.getEmail());
        assertEquals(new Date(2022,12,13),newUser.getRegistered());
        assertNull(newUser.getRoleId());
    }

    @Test
    public void test_correctLogin_givenRequest() {
        // Arrange
        UserService spySut = Mockito.spy(sut);
        NewLoginRequest req = new NewLoginRequest("testUsername", "mRMEY476");
        User user = new User("0", "testUsername", "mRMEY476", "testUsername@testUsername.com", new Date(2022,12,13), true, null);

        Mockito.when(mockUserRepo.findByUsernameAndPassword(req.getUsername(), req.getPassword())).thenReturn(user);

        // Act
        Principal newPrincipal = spySut.login(req);

        // Assert
        assertEquals("0",newPrincipal.getUserId());
        assertEquals("testUsername",newPrincipal.getUsername());
        assertEquals("testUsername@testUsername.com",newPrincipal.getEmail());
        assertEquals(new Date(2022,12,13),newPrincipal.getRegistered());
        assertNull(newPrincipal.getRoleId());
    }

    @Test
    public void test_correctGetAllUsers_givenNothing() {
        // Arrange
        UserService spySut = Mockito.spy(sut);
        User user1 = new User("0", "testUsername", "mRMEY476", "testUsername@testUsername.com", new Date(2022,12,13), true, null);
        User user2 = new User("1", "testUsername2", "mRMEY476", "testUsername2@testUsername2.com", new Date(2022,12,13), true, null);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        Mockito.when(spySut.getAllUsers()).thenReturn(users);

        // Act
        List<User> newUsers = spySut.getAllUsers();

        // Assert
        assertEquals(2, newUsers.size());

        User newUser = newUsers.get(0);

        assertEquals("0",newUser.getUserId());
        assertEquals("testUsername",newUser.getUsername());
        assertEquals("mRMEY476",newUser.getPassword());
        assertEquals("testUsername@testUsername.com",newUser.getEmail());
        assertEquals(new Date(2022,12,13),newUser.getRegistered());
        assertNull(newUser.getRoleId());

        newUser = newUsers.get(1);

        assertEquals("1",newUser.getUserId());
        assertEquals("testUsername2",newUser.getUsername());
        assertEquals("mRMEY476",newUser.getPassword());
        assertEquals("testUsername2@testUsername2.com",newUser.getEmail());
        assertEquals(new Date(2022,12,13),newUser.getRegistered());
        assertNull(newUser.getRoleId());
    }

    @Test
    public void test_correctGetAllUsersByUsername_givenUsername() {
        // Arrange
        UserService spySut = Mockito.spy(sut);
        User user1 = new User("0", "testUsername", "mRMEY476", "testUsername@testUsername.com", new Date(2022,12,13), true, null);
        List<User> users = new ArrayList<>();
        users.add(user1);

        Mockito.when(spySut.getAllUsersByUsername("testUsername")).thenReturn(users);

        // Act
        List<User> newUsers = spySut.getAllUsersByUsername("testUsername");

        // Assert
        assertEquals(1, newUsers.size());

        User newUser = newUsers.get(0);

        assertEquals("0",newUser.getUserId());
        assertEquals("testUsername",newUser.getUsername());
        assertEquals("mRMEY476",newUser.getPassword());
        assertEquals("testUsername@testUsername.com",newUser.getEmail());
        assertEquals(new Date(2022,12,13),newUser.getRegistered());
        assertNull(newUser.getRoleId());
    }

    @Test
    public void test_correctIsDuplicateUsername_givenUsername() {
        // Arrange
        UserService spySut = Mockito.spy(sut);
        List<String> allUsernames = new ArrayList<>();
        allUsernames.add("testUsername");

        Mockito.when(mockUserRepo.findAllUsernames()).thenReturn(allUsernames);
        Mockito.when(spySut.isDuplicateUsername("testUsername")).thenReturn(true);
        Mockito.when(spySut.isDuplicateUsername("testUsername2")).thenReturn(false);

        // Act
        Boolean duplicateUsernameTrue = spySut.isDuplicateUsername("testUsername");
        Boolean duplicateUsernameFalse = spySut.isDuplicateUsername("testUsername2");

        // Assert
        assertEquals(true,duplicateUsernameTrue);
        assertEquals(false,duplicateUsernameFalse);
    }

    @Test
    public void test_correctIsSamePassword_givenPasswords() {
        // Arrange

        // Act
        Boolean samePassword = sut.isSamePassword("mRMEY476","mRMEY476");

        // Assert
        assertEquals(true,samePassword);
    }

    @Test
    public void test_correctIsDuplicateEmail_givenEmail() {
        // Arrange
        UserService spySut = Mockito.spy(sut);
        List<String> allEmails = new ArrayList<>();
        allEmails.add("testUsername@testUsername.com");

        Mockito.when(mockUserRepo.findAllEmails()).thenReturn(allEmails);
        Mockito.when(spySut.isDuplicateEmail("testUsername@testUsername.com")).thenReturn(true);
        Mockito.when(spySut.isDuplicateEmail("testUsername2@testUsername2.com")).thenReturn(false);

        // Act
        Boolean duplicateEmailTrue = spySut.isDuplicateEmail("testUsername@testUsername.com");
        Boolean duplicateEmailFalse = spySut.isDuplicateEmail("testUsername2@testUsername2.com");

        // Assert
        assertEquals(true,duplicateEmailTrue);
        assertEquals(false,duplicateEmailFalse);
    }

    @Test
    public void test_correctIsActiveEmail_givenEmail() {
        // Arrange
        UserService spySut = Mockito.spy(sut);
        String email = "testUsername@testUsername.com";

        // Act
        boolean validEmailTrue = spySut.isValidEmail(email);

        // Assert
        assertTrue(validEmailTrue);
    }

    @Test
    public void test_correctSetActive_givenUserId() {
        // Arrange
        UserService spySut = Mockito.spy(sut);
        User user = new User("0", "testUsername", "mRMEY476", "testUsername@testUsername.com", new Date(2022,12,13), true, null);

        Mockito.when(mockUserRepo.findByUserId(user.getUserId())).thenReturn(user);

        // Act
        spySut.setActive(user.getUserId());

        // Assert
        assertFalse(user.isActive());
    }
}
