package com.revature.sylvester.repositories;

import com.revature.sylvester.entities.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, String> {
    @Query(value = "SELECT * FROM posts WHERE user_id = ?1", nativeQuery = true)
    List<Post> findAllByUserId(String userId);
}
