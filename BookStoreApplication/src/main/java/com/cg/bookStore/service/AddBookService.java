package com.cg.bookStore.service;

import com.cg.bookStore.dto.AddBookForm;
import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.entities.BookInformation;
import com.cg.bookStore.exceptions.CategoryException;

public interface AddBookService {
	

	public String addBook(BookInformation book) throws CategoryException;
}
