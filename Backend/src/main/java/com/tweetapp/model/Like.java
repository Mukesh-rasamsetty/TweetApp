package com.tweetapp.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document("like")
public class Like {
    @Id
	private String likeId;
	//private String message;
	private String msgPostTime;
	private String userName;
	private String tweetId;
	
	public String getLikeId() {
		return likeId;
	}
	public void setLikeId(String likeId) {
		this.likeId = likeId;
	}
	public String getMsgPostTime() {
		return msgPostTime;
	}
	public void setMsgPostTime(String msgPostTime) {
		this.msgPostTime = msgPostTime;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTweetId() {
		return tweetId;
	}
	public void setTweetId(String tweetId) {
		this.tweetId = tweetId;
	}
	
}
