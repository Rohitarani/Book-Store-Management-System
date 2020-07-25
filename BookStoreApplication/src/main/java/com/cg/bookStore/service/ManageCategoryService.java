package com.cg.bookStore.service;

import java.util.List;

import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.exceptions.CategoryException;

/**************************************************************************************************
 *          @author         Vainkatesh, Shashwat, Abhilash
 *          Description      It is an interface containing manage category functions. implementation will 
 *          					be done in implemented class. reference is to be given of this interface to user.
 *          Version             2.0
 *          Created Date    17-July-2020
 **************************************************************************************************/
public interface ManageCategoryService {

	public String createCategory(BookCategory category) throws CategoryException;
	public String deleteCategory(int categoryId) throws CategoryException;
	public String updateCategory(BookCategory category) throws CategoryException;
	public List<BookCategory> listAllCategory() throws CategoryException;
}