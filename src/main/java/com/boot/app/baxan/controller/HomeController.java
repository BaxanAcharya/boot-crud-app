package com.boot.app.baxan.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.boot.app.baxan.model.User;
import com.boot.app.baxan.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService us;
	
	@GetMapping("/")
	public String openHome()
	{
		
		return "home.html";
	}
	
	@PostMapping("/user")
	private String registerUser(@ModelAttribute User user)
	{
		us.save(user);
		return "home.html";
	}
		
	@GetMapping("/userLogin")
	private String openloginUser()
	{
		return "login.html";
	}
	
	@PostMapping("/loginuser")
	private String loginUser(@ModelAttribute User user, HttpSession session, Model m)
	{	
	User loggeduser=us.findByUsernameAndPassword(user.getUsername(),user.getPassword());
	if(loggeduser !=null)
	{
		System.out.println("login valyo");
		session.setAttribute("activeUser", loggeduser.getId());
		m.addAttribute("usersession",loggeduser.getUsername());
		m.addAttribute("users", us.findAll());
		return "afterlogin.html";
	}else
	{
		System.out.println("login vayena");
		m.addAttribute("error", "Invalid Username or Password");
		return "login.html";
	}
	}
	@GetMapping("/deleteall")
	public String deleteall()
	{
		System.out.println("Delete vayo");
		us.deleteAll();
		return "afterlogin.html";
	}
	
	
	@GetMapping("/deletebyid/{id}")
	public String deleteById(@PathVariable("id") int id, Model m )
	{
		us.deleteById(id);
		m.addAttribute("users", us.findAll());
		return "afterlogin.html";
	}
	
	@GetMapping("/userIndex")
	public String openAfterLogin(Model m)
	{
		m.addAttribute("users", us.findAll());
		return "afterlogin.html";
	}
	
	@GetMapping("/selectbyid/{id}")
	public String selectById(@PathVariable("id") int id, Model m )
	{
		
		m.addAttribute("userById", us.getOne(id));
		return "editUser.html";
	}
	
	@PostMapping("/editUser")
	public String editUser(@ModelAttribute User user,Model m)
	{
		us.saveAndFlush(user);
		m.addAttribute("users", us.findAll());
		return "afterlogin.html";
	}
}
