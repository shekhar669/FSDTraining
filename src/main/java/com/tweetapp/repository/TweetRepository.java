package com.tweetapp.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tweetapp.model.Tweet;

@Repository
public interface TweetRepository extends CrudRepository<Tweet, Long>{
	
	@Modifying
	@Query("update Tweet u set u.likes = :likes where u.id = :id")
	void updateLikes(@Param(value = "id") Integer id, @Param(value = "likes") Integer likes);

}
