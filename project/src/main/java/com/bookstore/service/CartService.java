package com.bookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.DTOs.CartBookDTO;
import com.bookstore.models.Book;
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
		
		cartRepository.addByUserIdAndBookId(userId, bookId);
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
		
		for(Cart item : cartItems) {
			bookRepository.subtractOneFromBookInventory(item.getBookId());
			cartRepository.removeByUserIdAndBookId(userId, item.getBookId());
		}
	}
	
	/**
	 * Method to get a list of books in the user's shopping cart
	 * @param userId
	 * @return list of Books in Cart Book format
	 */
	public List<CartBookDTO> getCartItems(int userId){
		
		List<Cart> cartItems = cartRepository.findByUserId(userId);
		Map<Cart, Long> cartItemsTracked = cartItems.stream().collect(Collectors.groupingBy((Function.identity()), Collectors.counting()));

		List<CartBookDTO> bookList = new ArrayList<CartBookDTO>();
			
		for(Entry<Cart, Long> entry : cartItemsTracked.entrySet() ) {
			Book book = bookRepository.findByBookId(entry.getKey().getBookId());
			
			CartBookDTO cartBook = new CartBookDTO();
			cartBook.setBookId(book.getBookId());
			cartBook.setBookName(book.getBookName());
			cartBook.setBookAuthor(book.getBookAuthor());
			cartBook.setBookGenre(book.getBookGenre());
			cartBook.setBookPrice(book.getBookPrice());
			cartBook.setBookPicture(book.getBookPicture());
			cartBook.setQuantity(entry.getValue());
			
			bookList.add(cartBook);
		}
		
		return bookList;
	}
}
