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
	private int bookId;
	
	@Column(name="book_name")
	private String bookName;
	
	@Column(name="book_author")
	private String bookAuthor;
	
	@Column(name="book_genre")
	private String bookGenre;
	
	@Column(name="book_price")
	private double bookPrice;
	
	@Column(name="book_picture")
	private byte[] bookPicture;
	
	@Column(name="inventory")
	private int bookInventory;
}
