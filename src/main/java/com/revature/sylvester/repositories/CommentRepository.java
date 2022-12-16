package com.revature.sylvester.repositories;

import com.revature.sylvester.entities.Comment;
import com.revature.sylvester.entities.Like;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, String> {
    @Query(value = "SELECT * FROM replies WHERE post_id = ?1", nativeQuery = true)
    List<Like> findAllByPostId(String postId);
}
