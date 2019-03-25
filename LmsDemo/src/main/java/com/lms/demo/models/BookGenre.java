package com.lms.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="book_genre")
public class BookGenre {
	
	@Id
	private int id;
	
	
	@Column(name="genre_name")
	private String bookGenre;
	
	
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBookGenre() {
		return bookGenre;
	}


	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}
	
	
	
	
}
