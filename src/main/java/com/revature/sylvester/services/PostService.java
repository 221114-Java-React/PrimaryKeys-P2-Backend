package com.revature.sylvester.services;

import com.revature.sylvester.dtos.requests.NewPostRequest;
import com.revature.sylvester.entities.Post;
import com.revature.sylvester.entities.User;
import com.revature.sylvester.repositories.PostRepository;
import com.revature.sylvester.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PostService {
    private final PostRepository postRepo;
    private final UserRepository userRepo;

    public PostService(PostRepository postRepo, UserRepository userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    public Post savePostByUserId(NewPostRequest req, String userId) {
        Post createdPost = new Post(UUID.randomUUID().toString(), new Date(), req.getContent(), req.getImgUrl());
        createdPost.setUser(userRepo.findByUserId(userId));

        postRepo.save(createdPost.getPostId(), createdPost.getPosted(), createdPost.getContent(),
                createdPost.getImgUrl(), userId);

        return createdPost;
    }

    public List<Post> getAllPosts() {
        return (List <Post>) postRepo.findAll();
    }

    public List<Post> getAllPostsByUserId(String userId) {
        return postRepo.findAllByUserId(userId);
    }

    public boolean isValidContent(String content) {
        return content.length() <= 128;
    }
}
