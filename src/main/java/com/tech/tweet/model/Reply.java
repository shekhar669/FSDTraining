package com.tech.tweet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "replies")
public class Reply {
	
	@Id
    @GeneratedValue
    @Column(columnDefinition = "INT unsigned")
    private Integer id;
	
	@NotEmpty
    @Column(columnDefinition = "text", nullable = false)
    private String message;
	
	@NotNull
    @Column(columnDefinition = "INT", nullable = false)
    private Integer tweetId;
	
	
    @Length(max = 64)
    @Column(columnDefinition = "VARCHAR(64)", length = 64, nullable = false)
    private String fromUser;


	@Override
	public String toString() {
		return "Reply [id=" + id + ", message=" + message + ", tweetId=" + tweetId + ", fromUser=" + fromUser + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Integer getTweetId() {
		return tweetId;
	}


	public void setTweetId(Integer tweetId) {
		this.tweetId = tweetId;
	}


	public String getFromUser() {
		return fromUser;
	}


	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
    
 
}
