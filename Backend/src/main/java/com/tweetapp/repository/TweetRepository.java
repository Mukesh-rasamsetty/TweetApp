package com.tweetapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tweetapp.model.Tweets;

@Repository
public interface TweetRepository extends MongoRepository<Tweets,String>{

	//@Query("{'userName':{'$regex':'?0','$options':'i'}}")
	List<Tweets> findTweetsByuserName(String userName);
	
    
	
}
