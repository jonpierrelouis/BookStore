package com.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.models.Cart;
import com.bookstore.repositories.BookRepository;
import com.bookstore.repositories.CartRepository;

@Service
public class CartService {
	
	private final CartRepository cartRepository;
	private final BookRepository bookRepository;

	@Autowired
	public CartService(CartRepository cartRepository, BookRepository bookRepository) {
		super();
		this.cartRepository = cartRepository;
		this.bookRepository = bookRepository;
	}
	
	/**
	 * This method adds a book into the user's cart
	 * @param userId the user's Id number
	 * @param bookId the book's Id number
	 */
	public void addBookToCart(int userId, int bookId) {
		
		Cart newCartEntry = new Cart(userId, bookId);
		
		cartRepository.save(newCartEntry);
	}

	/**
	 * This method removes a book from the user's cart
	 * @param userId the user's Id number
	 * @param bookId the book's Id number
	 */
	@Transactional
	public void removeBookFromCart(int userId, int bookId) {
		
		cartRepository.removeByUserIdAndBookId(userId, bookId);
	}
	
	/**
	 * This method also for the user to buy a book in their cart
	 * @param userId The user's Id number
	 */
	@Transactional
	public void purchaseBook(int userId) {
		
		List<Cart> cartItems = cartRepository.findByUserId(userId);
		System.out.println("userId: " +userId);
		
		for(Cart item : cartItems) {
			bookRepository.subtractOneFromBookInventory(item.getBookId());
			cartRepository.removeByUserIdAndBookId(userId, item.getBookId());
			System.out.println("Book Id: " + item.getBookId());
		}
	}
}
