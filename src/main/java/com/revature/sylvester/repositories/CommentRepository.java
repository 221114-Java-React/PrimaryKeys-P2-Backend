package com.revature.sylvester.repositories;

import com.revature.sylvester.entities.Comment;
import com.revature.sylvester.entities.Like;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, String> {
    @Modifying
    @Query(value = "INSERT INTO replies(reply_id, reply, replied, user_id, post_id) VALUES (?1, ?2, ?3, ?4, ?5)",
            nativeQuery = true)
    void save(String replyId, String reply, Date replied, String userId, String postId);

    @Query(value = "SELECT * FROM replies WHERE post_id = ?1", nativeQuery = true)
    List<Like> findAllByPostId(String postId);
}
