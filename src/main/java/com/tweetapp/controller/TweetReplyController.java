package com.tweetapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.model.Reply;
import com.tweetapp.repository.TweetReplyRepository;

@RestController
@CrossOrigin("*")
public class TweetReplyController {

	private final TweetReplyRepository tweetReplyRepository;

	@Autowired
	public TweetReplyController(TweetReplyRepository tweetReplyRepository) {
		this.tweetReplyRepository = tweetReplyRepository;
	}

	@PostMapping("/replies/add")
	@Transactional
	public Reply addReply(@RequestBody Reply reply){
		System.out.println("reply....." + reply);
		return tweetReplyRepository.save(reply);

	}

	@GetMapping("{tweetId}/replies/all")
	@Transactional
	public Iterable<Reply> showTweetReplyList(@PathVariable String tweetId) {
		return tweetReplyRepository.findByTweetId(Integer.valueOf(tweetId));
	}

}
