package com.bookstore.keys;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartKey implements Serializable {
	
	private int userId;
	
	private int bookId;

}
