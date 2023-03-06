package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.Repositories.BookRepository;
import com.bookstore.models.Book;

@Service
public class BookService {
	
	private final BookRepository bookRepository;	

	@Autowired
	public BookService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	/**
	 * 
	 * @return A list including all books in the repository
	 */
	public List<Book> seeAllBooks() {
		return bookRepository.findAll();
	}
	
}
