package com.tweetapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tweetapp.model.Like;
import com.tweetapp.model.Reply;
import com.tweetapp.model.Tweets;

public interface LikeRepository extends MongoRepository<Like,String> {
	List<Like> findLikeByUserName(String userName);
   
	
}
