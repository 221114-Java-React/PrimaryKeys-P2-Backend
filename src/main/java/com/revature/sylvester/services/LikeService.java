package com.revature.sylvester.services;

import com.revature.sylvester.entities.Like;
import com.revature.sylvester.repositories.LikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LikeService {
    private final LikeRepository likeRepo;

    public LikeService(LikeRepository likeRepo) {
        this.likeRepo = likeRepo;
    }

    public void saveLikeByUserIdAndPostId(String userId, String postId) {
        likeRepo.save(UUID.randomUUID().toString(), userId, postId);
    }

    public void deleteLikeByUserIdAndPostId(String userId, String postId) {
        likeRepo.delete(userId, postId);
    }

    public Like getLikeByUserIdAndPostId(String userId, String postId) {
        return likeRepo.findByUserIdAndPostId(userId, postId);
    }

    public List<Like> getAllLikesByUserId(String userId) {
        return likeRepo.findAllByUserId(userId);
    }

    public List<Like> getAllLikesByPostId(String postId) {
        return likeRepo.findAllByPostId(postId);
    }

    public boolean isLiked(String userId, String postId) {
        Like validLike = likeRepo.findByUserIdAndPostId(userId, postId);

        return validLike != null;
    }
}
