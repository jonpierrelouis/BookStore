package com.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.keys.CartKey;
import com.bookstore.models.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, CartKey>{
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM cart WHERE fk_user_id = ?1 AND fk_book_id = ?2",
			nativeQuery = true)
	public void removeByUserIdAndBookId(int userId, int bookId);
	
	@Modifying
	@Transactional
	public void removeByUserId(int userId);
	
	public List<Cart> findByUserId(int userId); 
	
	@Modifying
	@Transactional
	@Query(value="INSERT INTO cart VALUES (?1, ?2)",
			nativeQuery = true)
	public void addByUserIdAndBookId(int userId, int bookId);
}
