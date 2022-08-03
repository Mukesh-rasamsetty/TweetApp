package com.tweetapp.service;

import java.util.List;

import com.tweetapp.model.Like;
import com.tweetapp.model.Reply;
import com.tweetapp.model.Tweets;

public interface TweetService {

	List<Tweets> getAllTweets();

	Tweets postTweet(Tweets tweet, String userName);

	Tweets updateTweet(Tweets tweet, String tweetId);

	void deleteTweetbyId(String tweetId);

	Reply postReply(Reply reply);

	List<Tweets> getTweetsByUser(String userName);

	List<Tweets> getTweetsReply(String tweetId);
    Like  likeTweet(String userName,String tweetId);

}
