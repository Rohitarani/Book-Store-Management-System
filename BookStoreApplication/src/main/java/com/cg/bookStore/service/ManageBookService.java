package com.cg.bookStore.service;

import com.cg.bookStore.entities.BookInformation;
import com.cg.bookStore.exceptions.BookException;

public interface ManageBookService {

	public String deleteBook(int bookId) throws BookException;
	public String createBook(BookInformation book) throws BookException;
	public String updateBook(BookInformation book) throws BookException;
	public String displayBook(int bookId) throws BookException;
}
