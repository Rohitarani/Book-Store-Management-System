package com.cg.bookStore.dao;

import java.util.List;

import com.cg.bookStore.dto.BookForm;
import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.entities.BookInformation;
/**************************************************************************************************
*          @author         Rohita, Aishwarya, Amardeep, Sachin, Vainkatesh, Abhilash, Shashwat
*          Description      It is an interface containing dao functions. implementation will 
*          					be done in implemented class. reference is to be given of this interface to user.
*          Version             2.0
*          Created Date    17-July-2020
**************************************************************************************************/
public interface BookStoreDao {

	public boolean createCategory(BookCategory category);
	
	public boolean deleteBook(int bookId);
	public boolean addBook(BookInformation book);
	public List<BookInformation> listAllBooks();
	
	public boolean updateBookInfo(BookInformation bookInfo);
	
	public boolean updateCategory(BookCategory category);
	public boolean deleteCategory(int categoryId);
	
	public boolean categoryExists(String categoryName);
	public boolean categoryExists(int categoryId);
	public boolean bookExists(int bookId);
	public boolean bookExists(String bookName);
	public List<BookCategory> listAllCategory();

	boolean categoryContainsBook(int categoryId);

	BookCategory viewCategory(Integer categoryId);
}