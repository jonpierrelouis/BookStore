package com.bookstore.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

	public void subtractOneFromBookInventory(int bookId);
}
