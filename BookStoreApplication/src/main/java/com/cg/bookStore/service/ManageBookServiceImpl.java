package com.cg.bookStore.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookStore.dao.BookStoreDao;
import com.cg.bookStore.entities.BookInformation;
import com.cg.bookStore.exceptions.BookException;
import com.cg.bookStore.exceptions.CategoryException;

@Service
@Transactional
public class ManageBookServiceImpl implements ManageBookService {

	@Autowired
	private BookStoreDao dao;
	
	@Override
	public String deleteBook(int bookId) throws BookException {
		if(dao.deleteBook(bookId)) {
			return "Book deleted";
		}
		
		throw new BookException("Book not found");
	}
	
	public String createBook(BookInformation book) throws BookException{
		
		BookInformation bookInfo=new BookInformation();
		
		String bookTitle=bookInfo.getTitle();
		String bookDesc=bookInfo.getDescription();
		String bookAuthor=bookInfo.getAuthor();
		bookInfo.getPrice();
		String ISBNnum=bookInfo.getIsbnNumber();
		bookInfo.getPublishDate();
		
		if(bookTitle.isEmpty()) {
			throw new BookException("Cannot add empty book title");
		}
		
		if(bookTitle.length()<10 || bookTitle.length()>128) {
			throw new BookException("book title cannot be less than 5 characters and more than 30");
		}
		
		
		if(bookDesc.isEmpty()) {
			throw new BookException("Cannot add empty book description");
		}
		
		if(bookDesc.length()<200 || bookDesc.length()>2000) {
			throw new BookException("book description cannot be less than 200 characters and more than 2000");
		}
		
		
		if(bookAuthor.isEmpty()) {
			throw new BookException("Cannot add empty author name");
		}
		
		if(bookAuthor.length()<5 || bookAuthor.length()>65) {
			throw new BookException("author name cannot be less than 5 characters and more than 65");
		}
		
		
		if(ISBNnum.isEmpty()) {
			throw new BookException("Cannot add empty ISBN number");
		}
		
		if(ISBNnum.length()<10 || ISBNnum.length()>15) {
			throw new BookException("ISBN number cannot be less than 10 characters and more than 15");
		}
		return "added";
		
		
	}
	
	public String updateBook(BookInformation book) throws BookException{
		return "";
	}
	
	public String displayBook(int bookId) throws BookException{
		return "";
	}

}
