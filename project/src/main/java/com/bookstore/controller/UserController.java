package com.bookstore.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookstore.models.User;
import com.bookstore.service.UserService;

@Controller
public class UserController {
	
	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	/**
	 * This method allows for the creation of a new user
	 * @param session Http session
	 * @param req Http servlet request
	 * @return Returns the created user's information
	 */
	@PostMapping(value = "/register")
	public String createAccount(HttpSession session, HttpServletRequest req){
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String passwordConfirm = req.getParameter("passwordCONFIRM");
		
		if(!password.equals(passwordConfirm)) {
			return "redirect:/users/loginfallback.html";
		}
		
		//check to see if data exists
		//if it does send bad request
		Optional<User> optionalUser = userService.loginUser(username, password);
		
		if(optionalUser.isPresent()) {
			return "redirect:/users/registrationfallback.html";
		}
		
		//create account because it does not exist
		userService.createAccount(username, password);
		
		return "redirect:/users/index.html";
	}
	
	/**
	 * This method is to sign in a new user
	 * @param session Http session
	 * @param req Http servlet request
	 * @return The user object
	 */
	@PostMapping(value = "/login")
	public String loginUser(HttpSession session, HttpServletRequest req){
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Optional<User> optionalUser = userService.loginUser(username, password);
		
		if(!optionalUser.isPresent()) {
			return "redirect:/users/loginfallback.html";
		}
		
		session.setAttribute("userId", optionalUser.get().getUserId());
		
		return "redirect:/users/checkOne.html";
	}
	
	/**
	 * Method to allow a user to logout
	 * @param session
	 * @return Generic response entity holding no data
	 */
	@PostMapping("/logout")
	public String logoutUser(HttpSession session){
		session.removeAttribute("userId");
		
		System.out.println("logged out");
		return "redirect:/users/index.html";
	}

}
