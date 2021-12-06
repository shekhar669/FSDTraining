package com.tweetapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tweetapp.model.Reply;

@Repository
public interface TweetReplyRepository extends CrudRepository<Reply, Long>{
	List<Reply> findByTweetId(Integer tweetId);

}
