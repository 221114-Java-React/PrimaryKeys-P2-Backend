package com.revature.sylvester;

import com.revature.sylvester.entities.Post;
import com.revature.sylvester.entities.User;
import com.revature.sylvester.repositories.PostRepository;
import com.revature.sylvester.services.PostService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PostServiceTest {
    private PostRepository postRepositorySut;
    private PostService postServiceSut;

    @Before
    public void init() {
        postRepositorySut = Mockito.mock(PostRepository.class);
        postServiceSut = new PostService(postRepositorySut);
    }

//    @Test
//    public void test_correctGetAllPostsByUserId_givenUserId() {
//        // Arrange
//        PostService sut1 = Mockito.spy(postServiceSut);
//        PostRepository sut2 = Mockito.spy(postRepositorySut);
//        User user1 = new User("0", "testUsername", "mRMEY476", "testUsername@testUsername.com", new Date(2022,12,13), true, null);
//        Post post1 = new Post("0", new Date(2022,12,13), "first post", null, user1);
//        List<Post> posts = new ArrayList<>();
//        posts.add(post1);
//        String userId = user1.getUserId();
//
//        Mockito.when(sut2.findAllByUserId(userId)).thenReturn(posts);
//
//        // Act
//        List<Post> newPosts = sut2.findAllByUserId(userId);
//
//        // Assert
//        Post newPost = newPosts.get(0);
//
//        assertEquals("0",newPost.getPostId());
//        assertEquals(new Date(2022,12,13),newPost.getPosted());
//        assertEquals("first post",newPost.getContent());
//        assertEquals(null,newPost.getImgUrl());
//
//        User newUser = newPost.getUser();
//
//        assertEquals("0",newUser.getUserId());
//        assertEquals("testUsername",newUser.getUsername());
//        assertEquals("mRMEY476",newUser.getPassword());
//        assertEquals("testUsername@testUsername.com",newUser.getEmail());
//        assertEquals(new Date(2022,12,13),newUser.getRegistered());
//        assertEquals(null,newUser.getRoleId());
//    }
}
