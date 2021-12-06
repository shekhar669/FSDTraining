package com.tech.tweet.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tech.tweet.model.Reply;

public interface TweetReplyRepository extends CrudRepository<Reply, Long>{
	List<Reply> findByTweetId(Integer tweetId);

}
