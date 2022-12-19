package com.revature.sylvester.services;

import com.revature.sylvester.dtos.requests.NewPostRequest;
import com.revature.sylvester.entities.Post;
import com.revature.sylvester.repositories.LikeRepository;
import com.revature.sylvester.repositories.PostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PostService {
    private final PostRepository postRepo;
    private final LikeRepository likeRepo;

    public PostService(PostRepository postRepo, LikeRepository likeRepo) {
        this.postRepo = postRepo;
        this.likeRepo = likeRepo;
    }

    public void savePostByUserId(NewPostRequest req, String userId) {
        postRepo.save(UUID.randomUUID().toString(), new Date(), req.getContent(),
                req.getImgUrl(), userId);
    }

    public List<Post> getAllPosts() {
        return (List <Post>) postRepo.findAll();
    }

    public List<Post> getAllPostsByUserId(String userId) {
        return postRepo.findAllByUserId(userId);
    }

    public List<Post> getLikedPostsByUserId(String userId) {
        Iterable<Post> posts = postRepo.findAll();
        List<String> userLikedPostIds = likeRepo.findAllLikedPostIdsByUserId(userId);

        List<Post> filteredPosts = new ArrayList<>();
        for (Post post : posts) {
            if (userLikedPostIds.contains(post.getPostId())) {
                filteredPosts.add(post);
            }
        }

        return filteredPosts;
    }

    public List<Post> sortAllPostsByPosted() {
        return postRepo.sortAllByPosted();
    }

    public boolean isValidContent(String content) {
        return content.length() <= 128;
    }
}
