package com.tech.tweet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tweets")
public class Tweet {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "INT unsigned")
    private Integer id;

    
    @Length(max = 255)
    @Column(columnDefinition = "VARCHAR(255)", length = 255, nullable = false)
    private String profileImageUrl;

    @NotEmpty
    @Length(max = 64)
    @Column(columnDefinition = "VARCHAR(64)", length = 64, nullable = false)
    private String fromUser;

    @NotEmpty
    @Column(columnDefinition = "text", nullable = false)
    private String message;

    
    @Length(max = 255)
    @Column(columnDefinition = "VARCHAR(255)", length = 255, nullable = false)
    private String url;


    @Column(columnDefinition = "Date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createDate;
    
    
    @Column(columnDefinition = "INT default 0", nullable = false)
    private Integer likes;
	

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Tweet [id=" + id + ", profileImageUrl=" + profileImageUrl + ", fromUser=" + fromUser + ", message="
				+ message + ", url=" + url + ", createDate=" + createDate + "]";
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}   
	
	
}

