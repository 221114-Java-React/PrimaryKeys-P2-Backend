package com.revature.sylvester.services;

import com.revature.sylvester.entities.Post;
import com.revature.sylvester.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepo;

    public PostService(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    public List<Post> getAllPostsByUserId(String userId) {
        return postRepo.findAllByUserId(userId);
    }
}
