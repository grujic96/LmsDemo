package com.lms.demo.models;

import java.io.Serializable;
import java.util.Date;
import com.lms.demo.models.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity(name = "lmstb")
public class Book implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@NotNull
	private int id;
	
	@Column(name ="book_name")
	private String bookName;
	
	private String author;
	
	@Column(name ="purchase_date")
	@Temporal(TemporalType.DATE)
	private Date purchaseDate;
	
	@ManyToOne
    @JoinColumn(name = "genre_id")
	private BookGenre bookGenre;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public BookGenre getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(BookGenre bookGenre) {
		this.bookGenre = bookGenre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", author=" + author + ", purchaseDate=" + purchaseDate
				+ "]";
	}
	
		
}
