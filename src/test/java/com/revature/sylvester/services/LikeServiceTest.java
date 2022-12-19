package com.revature.sylvester.services;


import com.revature.sylvester.entities.Like;
import com.revature.sylvester.repositories.LikeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.UUID;

public class LikeServiceTest {
    private LikeService sut;
    private final LikeRepository mockLikeRepo = Mockito.mock(LikeRepository.class);

    @Before
    public void init() {
        sut = new LikeService(mockLikeRepo);
    }

    @Test
    public void test_saveLikeByUserIdAndPostId_givenValidUserIdAndPostId() {
        // Arrange
        LikeService spySut = Mockito.spy(sut);
        String validUserId = UUID.randomUUID().toString();
        String validPostId = UUID.randomUUID().toString();

        // Act
        spySut.saveLikeByUserIdAndPostId(validUserId, validPostId);

        // Assert
        Mockito.verify(mockLikeRepo, Mockito.times(1)).save(Mockito.anyString(),
                Mockito.eq(validUserId), Mockito.eq(validPostId));
    }

    @Test
    public void test_deleteLikeByUserIdAndPostId() {
        
    }
}