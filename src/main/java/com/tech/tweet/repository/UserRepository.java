package com.tech.tweet.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tech.tweet.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
    User findByName(String name);
    User findByEmail(String email);
	@Modifying
	@Query("update User u set u.password = :password where u.email = :email")
	@Transactional
	void updatePassword(@Param(value = "email") String email, @Param(value = "password") String password);
}