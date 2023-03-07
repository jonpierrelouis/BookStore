package com.bookstore.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.keys.CartKey;
import com.bookstore.models.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, CartKey>{
	
	public void removeByUserIdAndBookId(int userId, int bookId);
	
	public void removeByUserId(int userId);
}
