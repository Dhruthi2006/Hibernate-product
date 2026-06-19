package com.example.Book;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Hello world!
 *
 */
@Entity
public class Book
{
	@Id
	private int bookid;
	private String title;
	private String author;
	private String category;
	private double price;
	private int availCopies;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAvailCopies() {
		return availCopies;
	}
	public void setAvailCopies(int availCopies) {
		this.availCopies = availCopies;
	}
	
	
}
