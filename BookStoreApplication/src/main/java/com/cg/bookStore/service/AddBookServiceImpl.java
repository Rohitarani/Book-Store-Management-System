package com.cg.bookStore.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookStore.dao.BookStoreDao;
import com.cg.bookStore.dto.AddBookForm;
import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.entities.BookInformation;
import com.cg.bookStore.exceptions.CategoryException;

@Service
@Transactional
public class AddBookServiceImpl implements AddBookService {
	
	@Autowired
	private BookStoreDao dao;
	
	
	
		
		/*String bookTitle=bookInfo.getTitle();
		String bookDesc=bookInfo.getDescription();
		String bookAuthor=bookInfo.getAuthor();
		float bookPrice=bookInfo.getPrice();
		String ISBNnum=bookInfo.getIsbnNumber();
		LocalDate publishDate=bookInfo.getPublishDate();
		Integer copies_sold=bookInfo.getCopies_sold();
		BookCategory category_id=bookInfo.getCategory();*/
		
	@Override
	public String addBook(BookInformation book) throws CategoryException {
		BookInformation bookInfo=new BookInformation();
		
		String bookTitle=bookInfo.getTitle();
		String bookDesc=bookInfo.getDescription();
		String bookAuthor=bookInfo.getAuthor();
		bookInfo.getPrice();
		String ISBNnum=bookInfo.getIsbnNumber();
		bookInfo.getPublishDate();
		bookInfo.getCopies_sold();
		
		
		if(bookTitle.isEmpty()) {
			throw new CategoryException("Cannot add empty book title");
		}
		
		if(bookTitle.length()<10 || bookTitle.length()>128) {
			throw new CategoryException("book title cannot be less than 5 characters and more than 30");
		}
		
		
		if(bookDesc.isEmpty()) {
			throw new CategoryException("Cannot add empty book description");
		}
		
		if(bookDesc.length()<200 || bookDesc.length()>2000) {
			throw new CategoryException("book description cannot be less than 200 characters and more than 2000");
		}
		
		
		if(bookAuthor.isEmpty()) {
			throw new CategoryException("Cannot add empty author name");
		}
		
		if(bookAuthor.length()<5 || bookAuthor.length()>65) {
			throw new CategoryException("author name cannot be less than 5 characters and more than 65");
		}
		
		
		if(ISBNnum.isEmpty()) {
			throw new CategoryException("Cannot add empty ISBN number");
		}
		
		if(ISBNnum.length()<10 || ISBNnum.length()>15) {
			throw new CategoryException("ISBN number cannot be less than 10 characters and more than 15");
		}
		return "added";
		
		
		
		
		
			
		}

}
		/*BookInformation info=new BookInformation();
		info.setTitle(book.getBooktitle());
		
		info.setAuthor(book.getAuthor());
		
		info.setDescription(book.getDescription());
		
		info.setPrice(book.getPrice());
		
		info.setIsbnNumber(book.getIsbnno());
		
		info.setCopies_sold(book.getCopies());
		
		info.setPublishDate(book.getPublishdate());
		
		dao.addBook(info);
		
		return "added";*/
	
