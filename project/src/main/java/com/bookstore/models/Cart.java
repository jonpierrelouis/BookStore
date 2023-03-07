package com.bookstore.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.bookstore.keys.CartKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@IdClass(CartKey.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="cart")
public class Cart {

	@Id
	@Column(name="fk_user_id")
	private int userId;
	
	@Id
	@Column(name="fk_book_id")
	private int bookId;
	
}
