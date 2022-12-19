package com.revature.sylvester.services;

import com.revature.sylvester.entities.Like;
import com.revature.sylvester.repositories.LikeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
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

    public List<Like> getAllLikesByUserId(String userId) {
        return likeRepo.findAllByUserId(userId);
    }

    public List<Like> getAllLikesByPostId(String postId) {
        return likeRepo.findAllByPostId(postId);
    }

    public int getLikeCountByPostId(String postId) {
        return likeRepo.countAllLikesByPostId(postId);
    }

    public boolean isLiked(String userId, String postId) {
        Like validLike = likeRepo.findByUserIdAndPostId(userId, postId);

        return validLike != null;
    }
}
