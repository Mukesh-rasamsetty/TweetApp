package com.tweetapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tweetapp.model.Reply;
import com.tweetapp.model.Tweets;

public interface ReplyRepository extends MongoRepository<Reply,String> {

	@Query("{'tweetId':{'$regex':'?0','$options':'i'}}")
	List<Tweets> findReplyByTweet(String tweetId);

    void deleteByTweetId(String tweetId);


}
