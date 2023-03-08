package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.models.Book;
import com.bookstore.repositories.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepository;	

	@Autowired
	public BookService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	/**
	 * Function to fetch all books in the repository
	 * @return A list of books
	 */
	public List<Book> seeAllBooks() {
		return bookRepository.findAll();
	}
	
}
