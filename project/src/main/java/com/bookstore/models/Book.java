package com.bookstore.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="books")
public class Book {

	@Id
	@Column(name="book_id")
	int bookId;
	
	@Column(name="book_name")
	String bookName;
	
	@Column(name="book_author")
	String bookAuthor;
	
	@Column(name="book_genre")
	String bookGenre;
	
	@Column(name="book_price")
	double bookPrice;
	
	@Column(name="book_picture")
	byte[] bookPicture;
	
	@Column(name="inventory")
	int bookInventory;
}
