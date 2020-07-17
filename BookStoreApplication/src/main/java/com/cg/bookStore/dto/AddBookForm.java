package com.cg.bookStore.dto;

import java.time.LocalDate;

public class AddBookForm {

	private String booktitle;
	private String author;
	private String description;
	private float price;
	private LocalDate publishdate;
	private Integer copies;
	private String isbnno;
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public LocalDate getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(LocalDate publishdate) {
		this.publishdate = publishdate;
	}
	public Integer getCopies() {
		return copies;
	}
	public void setCopies(Integer copies) {
		this.copies = copies;
	}
	public String getIsbnno() {
		return isbnno;
	}
	public void setIsbnno(String isbnno) {
		this.isbnno = isbnno;
	}
	
	
	
}
