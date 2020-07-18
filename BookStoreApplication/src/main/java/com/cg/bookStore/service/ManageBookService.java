package com.cg.bookStore.service;

import java.util.List;

import com.cg.bookStore.entities.BookInformation;
import com.cg.bookStore.exceptions.BookException;

public interface ManageBookService {

	public String deleteBook(int bookId) throws BookException;
	public String createBook(BookInformation book) throws BookException;
	public String updateBook(BookInformation book) throws BookException;
	public List<BookInformation> displayBooks() throws BookException;
}
