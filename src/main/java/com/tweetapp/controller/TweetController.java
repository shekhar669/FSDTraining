package com.tweetapp.controller;

import java.text.ParseException;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.model.Tweet;
import com.tweetapp.repository.TweetRepository;

@RestController
@CrossOrigin("*")
public class TweetController {
	private final TweetRepository tweetRepository;

    @Autowired
    public TweetController(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }
    
    @PostMapping("/add")
    @Transactional
    public Tweet addUser(@RequestBody @Valid Tweet tweet) throws ParseException {
    	tweet.setCreateDate(new Date());
    	System.out.println("tweet" + tweet);
    	return tweetRepository.save(tweet);

    }

    @GetMapping("/all")
    @Transactional
	public Iterable<Tweet> showTweetList() {
		return tweetRepository.findAll();
	}
    

    @GetMapping("{tweetId}/likes")
    @Transactional
	public void updateLikes(@PathVariable String tweetId, @RequestParam String likes) {
    	System.out.println("likes..........."+ likes);
    	tweetRepository.updateLikes(Integer.valueOf(tweetId), Integer.valueOf(likes));
	}
    
}
