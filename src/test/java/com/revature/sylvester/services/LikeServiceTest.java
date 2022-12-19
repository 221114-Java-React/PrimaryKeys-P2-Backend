package com.revature.sylvester.services;

import com.revature.sylvester.entities.Like;
import com.revature.sylvester.repositories.LikeRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class LikeServiceTest {
    private LikeService sut;
    private final LikeRepository mockLikeRepo = Mockito.mock(LikeRepository.class);

    @Before
    public void init() {
        sut = new LikeService(mockLikeRepo);
    }

    /*@Test
    void test_saveLikeByUserIdAndPostId_givenValidUserIdAndPostId() {
        // Arrange
        LikeService spySut = Mockito.spy(sut);
        String validUserId = UUID.randomUUID().toString();
        String validPostId = UUID.randomUUID().toString();

        // Act
        spySut.saveLikeByUserIdAndPostId(validUserId, validPostId);

        // Assert
        Mockito.verify(mockLikeRepo, Mockito.times(1)).save(UUID.randomUUID().toString(),
                validUserId, validPostId);
    }*/

    @Test
    void test_deleteLikeByUserIdAndPostId() {
    }

    /*@Test
    void test_getAllLikesByUserId_givenValidUserId() {
        // Arrange
        String validUserId = UUID.randomUUID().toString();
        List<Like> stubbedLikes = Arrays.asList(new Like(), new Like(), new Like());
        Mockito.when(mockLikeRepo.findAllByUserId(validUserId)).thenReturn(stubbedLikes);

        // Act
        List<Like> condition = sut.getAllLikesByUserId(validUserId);

        // Assert
        assertFalse(condition.isEmpty());
    }*/

    @Test
    void test_getAllLikesByPostId() {
    }

    @Test
    void test_isLiked() {
    }
}