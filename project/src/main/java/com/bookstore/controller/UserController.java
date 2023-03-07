package com.bookstore.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.models.User;
import com.bookstore.service.UserService;

@RestController
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
	@PostMapping("/register")
	public ResponseEntity<User> createAccount(HttpSession session, HttpServletRequest req){
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		//check to see if data exists
		//if it does send bad request
		Optional<User> optionalUser = userService.loginUser(username, password);
		
		if(optionalUser.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createAccount(username, password));
	}
	
	/**
	 * This method is to sign in a new user
	 * @param session Http session
	 * @param req Http servlet request
	 * @return The user object
	 */
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(HttpSession session, HttpServletRequest req){
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Optional<User> optionalUser = userService.loginUser(username, password);
		
		if(!optionalUser.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		session.setAttribute("userId", optionalUser.get().getUserId());
		
		return ResponseEntity.ok(optionalUser.get());
	}
	
	/**
	 * Method to allow a user to logout
	 * @param session
	 * @return Generic response entity holding no data
	 */
	@PostMapping("/logout")
	public ResponseEntity<Void> logoutUser(HttpSession session){
		session.removeAttribute("userId");
		
		System.out.println("logged out");
		return ResponseEntity.ok().build();
	}

}
