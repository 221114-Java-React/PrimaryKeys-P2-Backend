package com.revature.sylvester.repositories;

import com.revature.sylvester.entities.Like;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LikeRepository extends CrudRepository<Like, String> {
    @Modifying
    @Query(value = "INSERT INTO likes(like_id, user_id, post_id) VALUES (?1, ?2, ?3)",
            nativeQuery = true)
    void save(String likeId, String userId, String postId);

    @Modifying
    @Query(value = "DELETE FROM likes WHERE user_id = ?1 AND post_id = ?2", nativeQuery = true)
    void delete(String user_id, String post_id);

    @Query(value = "SELECT * FROM likes WHERE user_id = ?1 AND post_id = ?2", nativeQuery = true)
    Like findByUserIdAndPostId(String userId, String post_id);

    @Query(value = "SELECT * FROM likes WHERE user_id = ?1", nativeQuery = true)
    List<Like> findAllByUserId(String userId);

    @Query(value = "SELECT * FROM likes WHERE post_id = ?1", nativeQuery = true)
    List<Like> findAllByPostId(String postId);
}