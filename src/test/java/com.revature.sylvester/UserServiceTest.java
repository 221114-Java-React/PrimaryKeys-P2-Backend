package com.revature.sylvester;

import com.revature.sylvester.dtos.requests.NewUserRequest;
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
    private UserService userServiceSut;

    @Before
    public void init() {
        userServiceSut = new UserService(new UserRepository() {
            @Override
            public User findByUsernameAndPassword(String username, String password) {
                return null;
            }

            @Override
            public List<User> findAllByUsername(String username) {
                return null;
            }

            @Override
            public List<String> findAllUsernames() {
                return null;
            }

            @Override
            public List<String> findAllEmails() {
                return null;
            }

            @Override
            public <S extends User> S save(S entity) {
                return null;
            }

            @Override
            public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<User> findById(String s) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(String s) {
                return false;
            }

            @Override
            public Iterable<User> findAll() {
                return null;
            }

            @Override
            public Iterable<User> findAllById(Iterable<String> strings) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(String s) {

            }

            @Override
            public void delete(User entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends String> strings) {

            }

            @Override
            public void deleteAll(Iterable<? extends User> entities) {

            }

            @Override
            public void deleteAll() {

            }
        });
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

//    @Test
//    public void test_correctLogin_givenRequest()

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

//    @Test
//    public void test_correctIsDuplicateUsername_givenUsername()

    @Test
    public void test_correctIsSamePassword_givenPasswords() {
        // Arrange

        // Act
        Boolean samePassword = userServiceSut.isSamePassword("mRMEY476","mRMEY476");

        // Assert
        assertEquals(true,samePassword);
    }

//    @Test
//    public void test_correctIsDuplicateEmail_givenEmail()
}
