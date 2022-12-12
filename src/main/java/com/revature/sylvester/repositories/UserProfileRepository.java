package com.revature.sylvester.repositories;

import com.revature.sylvester.entities.Post;
import com.revature.sylvester.entities.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile, String> {
    @Query(value = "SELECT * FROM user_profiles WHERE user_id = ?1", nativeQuery = true)
    List<Post> findByUserId(String userId);
}
