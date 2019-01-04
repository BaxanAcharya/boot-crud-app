package com.boot.app.baxan.controller;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class FacebookController {
	private Facebook facebook;
	private ConnectionRepository connectionRepository;
	public Facebook getFacebook() {
		return facebook;
	}
	public void setFacebook(Facebook facebook) {
		this.facebook = facebook;
	}
	public ConnectionRepository getConnectionRepository() {
		return connectionRepository;
	}
	public void setConnectionRepository(ConnectionRepository connectionRepository) {
		this.connectionRepository = connectionRepository;
		
	}
	
	
	@GetMapping("/feeds")
	public String getAllFeeds(Model model)
{
//		if(connectionRepository.getPrimaryConnection(Facebook.class==null))
//		{
//			return "redirect:/connect/facebook";
//		}
		PagedList<Post>post= facebook.feedOperations().getFeed();
		model.addAttribute("posts",post);
		model.addAttribute("profilename", post.get(0).getFrom().getName());
		return "profile.html";
	}
	
	
}
