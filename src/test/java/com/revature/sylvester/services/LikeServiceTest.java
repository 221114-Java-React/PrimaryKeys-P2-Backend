package com.revature.sylvester.services;

import com.revature.sylvester.repositories.LikeRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class LikeServiceTest {
    private LikeService sut;
    private final LikeRepository mockLikeRepo = Mockito.mock(LikeRepository.class);

    @Before
    public void init() {
        sut = new LikeService(mockLikeRepo);
    }

    @Test
    void test_saveLikeByUserIdAndPostId_givenValidUserIdAndPostId() {
        // Arrange

        // Act

        // Assert
    }

    @Test
    void test_deleteLikeByUserIdAndPostId() {
    }

    @Test
    void test_getAllLikesByUserId() {
    }

    @Test
    void test_getAllLikesByPostId() {
    }

    @Test
    void test_isLiked() {
    }
}