package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.models.Book;
import com.bookstore.service.BookService;

@RestController
public class BookController {
	
	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	/**
	 * @return A list of all books in the database
	 */
	@GetMapping(value="books")
	public List<Book> seeAllBooks(){
		return bookService.seeAllBooks();
		
	}
	

}
