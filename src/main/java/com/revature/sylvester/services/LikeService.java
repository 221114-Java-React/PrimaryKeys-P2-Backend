package com.revature.sylvester.services;

import com.revature.sylvester.entities.Like;
import com.revature.sylvester.repositories.LikeRepository;
import com.revature.sylvester.repositories.PostRepository;
import com.revature.sylvester.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LikeService {
    private final LikeRepository likeRepo;
    private final UserRepository userRepo;
    private final PostRepository postRepo;

    public LikeService(LikeRepository likeRepo, UserRepository userRepo, PostRepository postRepo) {
        this.likeRepo = likeRepo;
        this.userRepo = userRepo;
        this.postRepo = postRepo;
    }

    public Like saveByUserAndPostIds(String userId, String postId) {
        Like newLike = new Like(UUID.randomUUID().toString());
        newLike.setUser(userRepo.findByUserId(userId));
        newLike.setPost(postRepo.findByPostId(postId));
        likeRepo.save(newLike.getLikeId(), userId, postId);
        return newLike;
    }

    public Like getLikeByUserAndPostIds(String userId, String postId) {
        return likeRepo.findByUserAndPostIds(userId, postId);
    }

    public List<Like> getAllLikesByUserId(String userId) {
        return likeRepo.findAllByUserId(userId);
    }

    public List<Like> getAllLikesByPostId(String postId) {
        return likeRepo.findAllByPostId(postId);
    }

    public boolean isLiked(String userId, String postId) {
        Like validLike = likeRepo.findByUserAndPostIds(userId, postId);

        return validLike != null;
    }
}
