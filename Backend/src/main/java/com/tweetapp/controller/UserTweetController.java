package com.tweetapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.model.Like;
import com.tweetapp.model.Reply;
import com.tweetapp.model.Tweets;
import com.tweetapp.model.User;
import com.tweetapp.service.TweetService;
import com.tweetapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1.0/tweets")
public class UserTweetController {
private Logger log=LoggerFactory.getLogger(UserTweetController.class);
	@Autowired
	private UserService userService;

	@Autowired
	private TweetService tweetservice;

	//public Producer producer;

	@PostMapping(path = "/register")
	public User registerUSer(@RequestBody User user) {
		log.info("registration is required");
		return userService.registerUser(user);

	}

	@PostMapping(path = "/login")
	public User loginUser(@RequestBody User user) {
		User loggedInUser = userService.loginUser(user);
		System.out.println(loggedInUser);
		log.info("loging page");
		return loggedInUser;

	}

	@PutMapping(path = "/{userName}/forgot")
	public User updatePassword(@RequestBody User user, @PathVariable String userName) {
		User loggedInUser = userService.updatePassword(user, userName);
		System.out.println(loggedInUser);
		log.info("forgot password");
		return loggedInUser;

	}

	@GetMapping(path = "/user/all")
	public List<User> getAllUsers() {
		log.info("get all users");
		return userService.getAllUsers();
	}

	@GetMapping(path = "/user/search/{userName}")
	public User getUserByName(@PathVariable String userName) {
		log.info("search by username");
		return userService.getUserByName(userName);
	}

	@PostMapping(path = "/{userName}/add")
	public Tweets postTweet(@RequestBody Tweets tweet, @PathVariable String userName) {
		log.info("add the tweet");
		return tweetservice.postTweet(tweet, userName);

	}

	@GetMapping(path = "/all")
	public List<Tweets> getAllTweets() {
		List<Tweets> tweet = tweetservice.getAllTweets();
		log.info("get all tweets");
		return tweet;
	}

	@PutMapping(path = "/update/{tweetId}")
	public Tweets updateTweet(@RequestBody Tweets tweet, @PathVariable String tweetId) {
		Tweets updatedTweet = tweetservice.updateTweet(tweet, tweetId);
		log.info("updating the user details");
		return updatedTweet;
	}

	@DeleteMapping(path = "/delete/{tweetId}")
	public void deleteTweet(@PathVariable String tweetId) {
		tweetservice.deleteTweetbyId(tweetId);
        log.info("deleting the tweet");
	}

	@PostMapping(path = "/{userName}/reply")
	public Reply postReply(@RequestBody Reply reply) {
	       log.info("reply to post");
          return tweetservice.postReply(reply);
	}

	@GetMapping(path = "/all/{userName}")
	public List<Tweets> getTweetByUser(@PathVariable String userName) {
		log.info("finding user by username");
		return tweetservice.getTweetsByUser(userName);
	}

	@GetMapping(path = "/getReply/{tweetId}")
	public List<Tweets> getTweetReply(@PathVariable String tweetId) {
	       log.info("reply to tweet");
		return tweetservice.getTweetsReply(tweetId);
	}
	@PutMapping(path = "/{userName}/Like/{tweetId}")
	public Like likeTweet(@PathVariable String userName,@PathVariable String tweetId) {
		log.info("liking the tweet");
		return tweetservice.likeTweet(userName,tweetId);
	}


}
