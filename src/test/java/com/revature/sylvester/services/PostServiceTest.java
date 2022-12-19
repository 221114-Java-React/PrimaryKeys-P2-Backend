package com.revature.sylvester.services;

import com.revature.sylvester.dtos.requests.NewPostRequest;
import com.revature.sylvester.entities.Like;
import com.revature.sylvester.entities.Post;
import com.revature.sylvester.entities.User;
import com.revature.sylvester.repositories.PostRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

public class PostServiceTest {
    private PostService sut;
    private final PostRepository mockPostRepo = Mockito.mock(PostRepository.class);

    @Before
    public void init() {
        sut = new PostService(mockPostRepo);
    }

    @Test
    public void test_correctSavePostByUserId_givenRequestAndUserId() {
        // Arrange
        PostService spySut = Mockito.spy(sut);
        NewPostRequest req = new NewPostRequest("sample content", null);
        String userId = UUID.randomUUID().toString();

        // Act
        spySut.savePostByUserId(req, userId);

        // Assert
        Mockito.verify(mockPostRepo, Mockito.times(1)).save(Mockito.anyString(),
                Mockito.any(Date.class), Mockito.eq(req.getContent()), Mockito.eq(req.getImgUrl()), Mockito.eq(userId));
    }

    @Test
    public void test_correctGetAllPosts_givenNothing() {
        // Arrange
        PostService spySut = Mockito.spy(sut);
        User user1 = new User("0", "testUsername", "mRMEY476",
                "testUsername@testUsername.com", new Date(2022,12,13), true,
                null);

        List<Like> likes = new ArrayList<>();
        Like like1 = new Like("0",user1,null);
        likes.add(like1);
        Post post1 = new Post("0", new Date(2022,12,13), "first post", null,
                user1, likes);

        like1.setPost(post1);
        List<Post> posts = new ArrayList<>();
        posts.add(post1);

        Mockito.when(mockPostRepo.findAll()).thenReturn(posts);
        Mockito.when(spySut.getAllPosts()).thenReturn(posts);

        // Act
        List<Post> newPosts = spySut.getAllPosts();

        // Assert
        Post newPost = newPosts.get(0);

        assertEquals("0",newPost.getPostId());
        assertEquals(new Date(2022,12,13),newPost.getPosted());
        assertEquals("first post",newPost.getContent());
        assertNull(newPost.getImgUrl());

        User newUser = newPost.getUser();

        assertEquals("0",newUser.getUserId());
        assertEquals("testUsername",newUser.getUsername());
        assertEquals("mRMEY476",newUser.getPassword());
        assertEquals("testUsername@testUsername.com",newUser.getEmail());
        assertEquals(new Date(2022,12,13),newUser.getRegistered());
        assertNull(newUser.getRoleId());

        Like newLike = newPost.getLikes().get(0);

        assertEquals("0",newLike.getLikeId());
        assertEquals(newUser,newLike.getUser());
        assertEquals(newPost,newLike.getPost());
    }

    @Test
    public void test_correctGetAllPostsByUserId_givenUserId() {
        // Arrange
        PostService spySut = Mockito.spy(sut);
        User user1 = new User("0", "testUsername", "mRMEY476",
                "testUsername@testUsername.com", new Date(2022,12,13), true,
                null);

        List<Like> likes = new ArrayList<>();
        Like like1 = new Like("0",user1,null);
        likes.add(like1);
        Post post1 = new Post("0", new Date(2022,12,13), "first post", null,
                user1, likes);

        like1.setPost(post1);
        List<Post> posts = new ArrayList<>();
        posts.add(post1);
        String userId = user1.getUserId();

        Mockito.when(mockPostRepo.findAllByUserId(userId)).thenReturn(posts);
        Mockito.when(spySut.getAllPostsByUserId(userId)).thenReturn(posts);

        // Act
        List<Post> newPosts = spySut.getAllPostsByUserId(userId);

        // Assert
        Post newPost = newPosts.get(0);

        assertEquals("0",newPost.getPostId());
        assertEquals(new Date(2022,12,13),newPost.getPosted());
        assertEquals("first post",newPost.getContent());
        assertNull(newPost.getImgUrl());

        User newUser = newPost.getUser();

        assertEquals("0",newUser.getUserId());
        assertEquals("testUsername",newUser.getUsername());
        assertEquals("mRMEY476",newUser.getPassword());
        assertEquals("testUsername@testUsername.com",newUser.getEmail());
        assertEquals(new Date(2022,12,13),newUser.getRegistered());
        assertNull(newUser.getRoleId());

        Like newLike = newPost.getLikes().get(0);

        assertEquals("0",newLike.getLikeId());
        assertEquals(newUser,newLike.getUser());
        assertEquals(newPost,newLike.getPost());
    }

    @Test
    public void test_correctSortAllPostsByPosted_givenNothing() {
        // Arrange
        PostService spySut = Mockito.spy(sut);
        User user1 = new User("0", "testUsername", "mRMEY476",
                "testUsername@testUsername.com", new Date(2022,12,13), true,
                null);

        List<Like> likes = new ArrayList<>();
        Like like1 = new Like("0",user1,null);
        likes.add(like1);
        Post post1 = new Post("0", new Date(2022,12,13), "first post", null,
                user1, likes);

        like1.setPost(post1);
        List<Post> posts = new ArrayList<>();
        posts.add(post1);

        Mockito.when(mockPostRepo.sortAllByPosted()).thenReturn(posts);
        Mockito.when(spySut.sortAllPostsByPosted()).thenReturn(posts);

        // Act
        List<Post> newPosts = spySut.sortAllPostsByPosted();

        // Assert
        Post newPost = newPosts.get(0);

        assertEquals("0",newPost.getPostId());
        assertEquals(new Date(2022,12,13),newPost.getPosted());
        assertEquals("first post",newPost.getContent());
        assertNull(newPost.getImgUrl());

        User newUser = newPost.getUser();

        assertEquals("0",newUser.getUserId());
        assertEquals("testUsername",newUser.getUsername());
        assertEquals("mRMEY476",newUser.getPassword());
        assertEquals("testUsername@testUsername.com",newUser.getEmail());
        assertEquals(new Date(2022,12,13),newUser.getRegistered());
        assertNull(newUser.getRoleId());

        Like newLike = newPost.getLikes().get(0);

        assertEquals("0",newLike.getLikeId());
        assertEquals(newUser,newLike.getUser());
        assertEquals(newPost,newLike.getPost());
    }

    @Test
    public void test_correctIsValidContent_givenContent() {
        // Arrange
        String content1 = "this content is good";
        String content2 = "this content is bad!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" +
                "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";

        // Act
        Boolean goodContent = sut.isValidContent(content1);
        Boolean badContent = sut.isValidContent(content2);

        // Assert
        assertEquals(true, goodContent);
        assertEquals(false, badContent);
    }

    @Test
    public void test_correctGetLikedPostsByUserLikedPostIds_givenUserLikedPostIds() {
        // Arrange
        String userLikedPostId = UUID.randomUUID().toString();
        User user1 = new User("0", "testUsername", "mRMEY476",
                "testUsername@testUsername.com", new Date(2022,12,13), true,
                null);

        Post post1 = new Post("0", new Date(2022,12,13), "first post", null);

        Post post2 = new Post(userLikedPostId, new Date(2022,12,13), "sample post",
                null);

        List<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        List<String> userLikedPostIds = new ArrayList<>();
        userLikedPostIds.add(userLikedPostId);

        Mockito.when(mockPostRepo.findAll()).thenReturn(posts);

        // Act
        List<Post> condition = sut.getLikedPostsByUserLikedPostIds(userLikedPostIds);

        // Assert
        assertNotNull(condition);
    }
}
