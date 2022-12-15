package com.revature.sylvester;

import com.revature.sylvester.dtos.requests.NewUserRequest;
import com.revature.sylvester.entities.User;
import com.revature.sylvester.entities.UserProfile;
import com.revature.sylvester.repositories.UserProfileRepository;
import com.revature.sylvester.repositories.UserRepository;
import com.revature.sylvester.services.UserProfileService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class UserProfileServiceTest {
    private UserProfileRepository userProfileRepositorySut;
    private UserRepository userRepositorySut;
    private UserProfileService userProfileServiceSut;

    @Before
    public void init() {
        userProfileRepositorySut = Mockito.mock(UserProfileRepository.class);
        userRepositorySut = Mockito.mock(UserRepository.class);
        userProfileServiceSut = new UserProfileService(userProfileRepositorySut,userRepositorySut);
    }

    @Test
    public void test_correctCreateProfile_givenRequest() {
        // Arrange
        UserProfileService sut1 = Mockito.spy(userProfileServiceSut);
        UserRepository sut2 = Mockito.spy(userRepositorySut);
        NewUserRequest req = new NewUserRequest("testUsername", "mRMEY476", "mRMEY476", "testUsername@testUsername.com", "testDisplayName", LocalDate.of(2022,12,13));
        User user = new User("0", "testUsername", "mRMEY476", "testUsername@testUsername.com", new Date(2022,12,13), true, null);
        UserProfile userProfile = new UserProfile("0", req.getDisplayName(), null, req.getBirthDate(), null, null, null, user);

        Mockito.when(sut2.findByUsernameAndPassword(req.getUsername(), req.getPassword1())).thenReturn(user);
        Mockito.when(sut1.createProfile(req, user)).thenReturn(userProfile);

        // Act
        UserProfile newUserProfile = sut1.createProfile(req, user);

        // Assert
        assertEquals("0",newUserProfile.getProfileId());
        assertEquals(req.getDisplayName(),newUserProfile.getDisplayName());
        assertEquals(null,newUserProfile.getLocation());
        assertEquals(req.getBirthDate(),newUserProfile.getBirthDate());
        assertEquals(null,newUserProfile.getOccupation());
        assertEquals(null,newUserProfile.getBio());
        assertEquals(null,newUserProfile.getProfilePicUrl());

        User newUser = newUserProfile.getUser();

        assertEquals("0",newUser.getUserId());
        assertEquals("testUsername",newUser.getUsername());
        assertEquals("mRMEY476",newUser.getPassword());
        assertEquals("testUsername@testUsername.com",newUser.getEmail());
        assertEquals(new Date(2022,12,13),newUser.getRegistered());
        assertEquals(null,newUser.getRoleId());
    }

    @Test
    public void test_correctGetProfileByUserId_givenUserId() {
        // Arrange
        UserProfileService sut1 = Mockito.spy(userProfileServiceSut);
        UserProfileRepository sut3 = Mockito.spy(userProfileRepositorySut);
        User user = new User("0", "testUsername", "mRMEY476", "testUsername@testUsername.com", new Date(2022,12,13), true, null);
        UserProfile userProfile = new UserProfile("0", "testDisplayName", null, LocalDate.of(2022,12,13), null, null, null, user);

        Mockito.when(sut3.findByUserId("0")).thenReturn(userProfile);
        Mockito.when(sut1.getProfileByUserId("0")).thenReturn(userProfile);

        // Act
        UserProfile newUserProfile = sut1.getProfileByUserId("0");

        // Assert
        assertEquals("0",newUserProfile.getProfileId());
        assertEquals("testDisplayName",newUserProfile.getDisplayName());
        assertEquals(null,newUserProfile.getLocation());
        assertEquals(LocalDate.of(2022,12,13),newUserProfile.getBirthDate());
        assertEquals(null,newUserProfile.getOccupation());
        assertEquals(null,newUserProfile.getBio());
        assertEquals(null,newUserProfile.getProfilePicUrl());

        User newUser = newUserProfile.getUser();

        assertEquals("0",newUser.getUserId());
        assertEquals("testUsername",newUser.getUsername());
        assertEquals("mRMEY476",newUser.getPassword());
        assertEquals("testUsername@testUsername.com",newUser.getEmail());
        assertEquals(new Date(2022,12,13),newUser.getRegistered());
        assertEquals(null,newUser.getRoleId());
    }

    @Test
    public void test_correctIsEmptyDisplayName_giveDisplayName() {
        // Arrange

        // Act
        Boolean notEmptyDisplayName = userProfileServiceSut.isEmptyDisplayName("testDisplayName");
        Boolean emptyDisplayName = userProfileServiceSut.isEmptyDisplayName("");

        // Assert
        assertEquals(false,notEmptyDisplayName);
        assertEquals(true,emptyDisplayName);
    }

    @Test
    public void test_correctIsValidBirthDate_givenBirthDate() {
        // Arrange

        // Act
        Boolean validBirthDate = userProfileServiceSut.isValidBirthDate(LocalDate.of(2000, 12, 13));
        Boolean invalidBirthDate = userProfileServiceSut.isValidBirthDate(LocalDate.of(2022, 12, 13));

        // Assert
        assertEquals(true,validBirthDate);
        assertEquals(false,invalidBirthDate);
    }
}
