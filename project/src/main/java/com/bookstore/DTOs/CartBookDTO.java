package com.bookstore.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartBookDTO {

	private int bookId;
	
	private String bookName;
	
	private String bookAuthor;
	
	private String bookGenre;
	
	private double bookPrice;
	
	private byte[] bookPicture;
	
	private Long quantity;

}
