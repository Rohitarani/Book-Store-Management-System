package com.cg.bookStore.dao;

import java.util.List;

import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.entities.BookInformation;

public interface BookStoreDao {

	public boolean createCategory(BookCategory category);
	
	public boolean deleteBook(int bookId);
	public boolean addBook(BookInformation bookInfo);
	public List<BookInformation> listAllBooks();
	
	public boolean updateBookInfo(BookInformation bookInfo);
	
	public boolean updateCategory(BookCategory category);
	public boolean deleteCategory(int categoryId);
	
	public boolean categoryExists(String categoryName);
	public boolean categoryExists(int categoryId);
	public boolean bookExists(int bookId);
	public boolean bookExists(String bookName);
}
