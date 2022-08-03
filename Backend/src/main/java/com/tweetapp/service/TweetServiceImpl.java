package com.tweetapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tweetapp.model.Like;
import com.tweetapp.model.Reply;
import com.tweetapp.model.Tweets;
import com.tweetapp.repository.LikeRepository;
import com.tweetapp.repository.ReplyRepository;
import com.tweetapp.repository.TweetRepository;

@Service
public class TweetServiceImpl implements TweetService {

	@Autowired
	private TweetRepository tweetRepository;

	@Autowired
	private ReplyRepository replyRepository;
	@Autowired
	private LikeRepository likeRepository;

   public Tweets tweets;
	public List<Tweets> getAllTweets() {
		List<Tweets> allTweets = new ArrayList<Tweets>();
		try {
			allTweets = tweetRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allTweets;

	}

	public Tweets postTweet(Tweets tweet, String userName) {
		Tweets savedTweet=new Tweets();
		try {
		tweet.setUserName(userName);
		savedTweet= tweetRepository.save(tweet);}
		catch (Exception e) {
			e.printStackTrace();
		}
		return savedTweet;
	}

	public Tweets updateTweet(Tweets tweet, String tweetId) {
		tweet.setTweetId(tweetId);
		return tweetRepository.save(tweet);

	}

	public void deleteTweetbyId(String tweetId) {
		try {
			tweetRepository.deleteById(tweetId);
			replyRepository.deleteByTweetId(tweetId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	public Reply postReply(Reply reply) {
		Reply tweetReply = new Reply();
		try {
			tweetReply = replyRepository.save(reply);

		} catch (DataAccessException exception) {
			exception.printStackTrace();
		}
		return tweetReply;

	}
	public Like likeTweet(String userName,String tweetId){
		List<Like> findAll = likeRepository.findAll();
		Like like=null;
		if(findAll.size()==0){
			 Like likes=new Like();
	            likes.setUserName(userName);
	            likes.setMsgPostTime(new String());
	            likes.setTweetId(tweetId);
	            Like save = likeRepository.save(likes);
	            like=save;
		}
		else
		{
			for(int i=0;i<findAll.size();i++){
				if(userName.equals(findAll.get(i).getUserName())){
					//findAll.remove(findAll.get(i));
					likeRepository.deleteById(findAll.get(i).getLikeId());
					
				}
				else{
					 Like likes=new Like();
			            likes.setUserName(userName);
			            likes.setMsgPostTime(new String());
			            likes.setTweetId(tweetId);
			            Like save = likeRepository.save(likes);
			            like=save;
			           
				}
			}}
            return like;
	}
	

	public List<Tweets> getTweetsByUser(String userName) {
		return tweetRepository.findTweetsByuserName(userName);

	}

	public List<Tweets> getTweetsReply(String tweetId) {
		return replyRepository.findReplyByTweet(tweetId);

	}

//	public Like likeTweet(Like like) {
//		// TODO Auto-generated method stub
//		return null;
//	}



}
