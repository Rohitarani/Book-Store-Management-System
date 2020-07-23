package com.cg.bookStore.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cg.bookStore.entities.BookInformation;
import com.cg.bookStore.exceptions.BookException;

public interface ManageBookService {

	public String deleteBook(int bookId) throws BookException;
	public String createBook(BookInformation book,MultipartFile file) throws BookException, IOException;
	public String updateBook(BookInformation book) throws BookException;
	public List<BookInformation> displayBooks() throws BookException;
}
