package com.cg.bookStore.dao;

import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.entities.BookInformation;

public interface BookStoreDao {
	public boolean addBook(BookInformation bookInfo);
	public Boolean createCategory(BookCategory category);
	public Boolean findCategory(String categoryName);
}

