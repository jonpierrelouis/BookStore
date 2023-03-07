package com.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.Repositories.UserRepository;
import com.bookstore.models.User;

@Service
public class UserService {

	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	/**
	 * Function used to create a new account
	 * @param username Username of the account to be created
	 * @param password Password of the account to be created
	 * @return the User object containing the username and password
	 */
	public User createAccount(String username, String password) {
		
		User newUser = new User(username, password);
		
		return userRepository.save(newUser);
	}
	
	/**
	 * Function to check user credentials for login
	 * @param username Username of the account to be created
	 * @param password Password of the account to be created
	 * @return the User object containing the username and password
	 */
	public Optional<User> loginUser(String username, String password) {
		
		return userRepository.findByUserNameAndUserPassword(username, password);
	}
	
}
