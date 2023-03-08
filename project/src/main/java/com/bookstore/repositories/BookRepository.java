package com.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookstore.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

	@Modifying
	@Query(value="UPDATE books SET inventory = inventory-1 WHERE book_id = ?1",
			nativeQuery = true)
	public void subtractOneFromBookInventory(int bookId);
}
