package com.cg.bookStore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="bookstore_customer_review")
@DynamicInsert
@DynamicUpdate
public class CustomerReview {
	
	@Id
	@Column(name="review_id")
	private int reviewId;
	
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="book_rating")
	@Min(1)
	@Max(2)
	private int bookRating;
	
	@Column(name="review_headline")
	@Size(min=20,max=128)
	private String reviewHeadline;
	
	@Column(name="review_comment",length=300)
	@Size(min=100,max=300)
	private String reviewComment;

	@ManyToOne
	@JoinColumn(name="book_id", referencedColumnName = "book_id")
	private BookInformation book = new BookInformation();

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getBookRating() {
		return bookRating;
	}

	public void setBookRating(int bookRating) {
		this.bookRating = bookRating;
	}

	public String getReviewHeadline() {
		return reviewHeadline;
	}

	public void setReviewHeadline(String reviewHeadline) {
		this.reviewHeadline = reviewHeadline;
	}

	public String getReviewComment() {
		return reviewComment;
	}

	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}

	public BookInformation getBook() {
		return book;
	}

	public void setBook(BookInformation book) {
		this.book = book;
	}

	
	
	
	
}
