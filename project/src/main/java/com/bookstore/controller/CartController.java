package com.bookstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.models.Book;
import com.bookstore.service.CartService;

@RestController
public class CartController {
	
	private final CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		super();
		this.cartService = cartService;
	}
	
	/**
	 * Method to add a book to the user's cart using the book id
	 * @param session HttpSession
	 * @param req HttpServletRequest
	 * @return void
	 */
	@PostMapping("/addBookToCart")
	public ResponseEntity<Void> addBookToCart(HttpSession session, HttpServletRequest req){
		
		Object userId = session.getAttribute("userId");
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		
		cartService.addBookToCart((Integer) userId, bookId);
	
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Method to remove a book from the user's cart using the book id
	 * @param session HttpSession
	 * @param req HttpServletRequest
	 * @return void
	 */
	@PostMapping("/removeBookFromCart")
	public ResponseEntity<Void> removeBookFromCart(HttpSession session, HttpServletRequest req){
		
		Object userId = session.getAttribute("userId");
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		
		cartService.removeBookFromCart((Integer) userId, bookId);
		
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Method to purchase all items in the cart
	 * @param session HttpSession
	 * @return void
	 */
	@PostMapping("/purchaseBooks")
	public ResponseEntity<Void> purchaseBook(HttpSession session){
		
		Object userId = session.getAttribute("userId");
		
		cartService.purchaseBook((Integer) userId);
		
		return ResponseEntity.ok().build();
	}

	/**
	 * Method to see the information about the items in the cart
	 * @param session HttpSession
	 * @return a List of books
	 */
	@GetMapping("/getCartItems")
	public ResponseEntity<List<Book>> getCartItems(HttpSession session){
		
		Object userId = session.getAttribute("userId");
		
		List<Book> bookList = cartService.getCartItems((Integer) userId);
		
		return ResponseEntity.ok(bookList);
	}
	
}
