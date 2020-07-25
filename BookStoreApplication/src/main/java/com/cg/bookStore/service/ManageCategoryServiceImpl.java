package com.cg.bookStore.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookStore.dao.BookStoreDao;
import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.exceptions.CategoryException;
import com.cg.bookStore.util.BookStoreConstants;

/**************************************************************************************************
 *          @author         Vainkatesh, Shashwat, Abhilash
 *          Description      This class implements the ManageCategoryService interface.
 *          Version             2.0
 *          Created Date    17-July-2020
 **************************************************************************************************/
@Service
@Transactional
public class ManageCategoryServiceImpl implements ManageCategoryService{

	@Autowired
	private BookStoreDao bookStoreDao;
	
	/*******************************************
	 * Method: createCategory
     *Description: Write business logic for create category
	 * @param name              - category.
	 * @returns shows(String)   - Message that category added or not
	 * @throws CategoryException - When that category does already exists in database, exception is thrown. 
                *Created By                              - Shashwat khare
                *Created Date                            - 17-Jul-2020                           	 
	 ********************************************/
	@Override
	public String createCategory(BookCategory category) throws CategoryException {
		String categoryName = category.getCategoryName();
		categoryName = categoryName.toLowerCase();
		if(categoryName.isEmpty()) {
			throw new CategoryException(BookStoreConstants.EMPTY_CATEGORY);
		}
		
		if(categoryName.length()<5 || categoryName.length()>30) {
			throw new CategoryException(BookStoreConstants.CATEGORY_VALIDATION);
		}
		
		if(bookStoreDao.categoryExists(categoryName)) {
			throw new CategoryException(BookStoreConstants.CATEGORY_EXISTS);
		}
		
		bookStoreDao.createCategory(category);
		return BookStoreConstants.CATEGORY_ADDED;
		
		
	}

	/*******************************************
	 * Method: deleteCategory
     *Description: To write the business logic for delete category.
	 * @param name              - categoryId.
	 * @returns shows(String)   - Message that category deleted or not
	 * @throws CategoryException - When that category does not exists in database, exception is thrown. 
                *Created By                              - Abhilash Mishra
                *Created Date                            - 17-Jul-2020                           	 
	 ********************************************/
	@Override
	public String deleteCategory(int categoryId) throws CategoryException {
	if(bookStoreDao.categoryExists(categoryId)) {
			if(!bookStoreDao.categoryContainsBook(categoryId))
				return BookStoreConstants.CATEGORY_NOT_EMPTY;
			else {
			bookStoreDao.deleteCategory(categoryId);
			return BookStoreConstants.CATEGORY_DELETED;
			}
		}
		throw new CategoryException(BookStoreConstants.CATEGORY_DOES_NOT_EXIST);
	}

	/*******************************************
	 * Method: updateCategory
     *Description: To write the business logic for update category.. 
	 * @param name              - category.
	 * @returns shows(String)   - Message that category added or not
	 * @throws CategoryException - When that category does not exists in database, exception is thrown. 
                *Created By                              - Vainkatesh prasad jangid
                *Created Date                            - 17-Jul-2020                           	 
	 ********************************************/
	@Override
	public String updateCategory(BookCategory category) throws CategoryException {
		
		if(bookStoreDao.categoryExists(category.getCategoryId())) {
			if(bookStoreDao.updateCategory(category)) {
				return BookStoreConstants.CATEGORY_UPDATED;
			}
			throw new CategoryException(BookStoreConstants.CATEGORY_EXISTS);
		}
		
		throw new CategoryException(BookStoreConstants.CATEGORY_DOES_NOT_EXIST);
	}

	/*******************************************
	 * Method: displayAllCategory
     *Description: To write the business logic for display all categories.  
	 * @returns List<BookCategory>   - List all all categories
	 * @throws CategoryException - No category, exception is thrown. 
                *Created By                              - Abhilash Mishra
                *Created Date                            - 19-Jul-2020                           	 
	 ********************************************/
	@Override
	public List<BookCategory> listAllCategory() throws CategoryException {
		List<BookCategory> allBooks = bookStoreDao.listAllCategory();
		if(allBooks.isEmpty()) {
			throw new CategoryException(BookStoreConstants.CATEGORY_DOES_NOT_EXIST);
		}
		return allBooks;
	}

	
}