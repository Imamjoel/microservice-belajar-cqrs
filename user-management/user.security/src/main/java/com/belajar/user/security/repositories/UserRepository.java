package com.belajar.user.security.repositories;

import com.belajar.user.core.User;
import org.springframework.data.mongodb.repository.Query;


public interface UserRepository extends MongoRepository<User, String> {
    @Query("{'account.username': ?0}")
    Optional<User> findByUsername(String username);
}
