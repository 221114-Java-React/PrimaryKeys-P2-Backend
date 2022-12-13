package com.revature.sylvester.repositories;

import com.revature.sylvester.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    @Query(value = "SELECT * FROM users WHERE username = ?1 AND password ?2", nativeQuery = true)
    User findByUsernameAndPassword(String username, String password);

    List<User> findAllByUsername(String username);

    @Query(value = "SELECT (username) FROM users WHERE username = ?1", nativeQuery = true)
    List<String> findAllUsernames(String username);

    @Query(value = "SELECT (email) FROM users WHERE email = ?1", nativeQuery = true)
    List<String> findAllEmails(String email);
}
