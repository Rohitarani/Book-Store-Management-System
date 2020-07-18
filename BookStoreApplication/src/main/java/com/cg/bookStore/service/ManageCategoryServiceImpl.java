package com.cg.bookStore.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookStore.dao.BookStoreDao;
import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.exceptions.CategoryException;
import com.cg.bookStore.util.BookStoreConstants;

@Service
@Transactional
public class ManageCategoryServiceImpl implements ManageCategoryService{

	@Autowired
	private BookStoreDao bookStoreDao;
	
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

	@Override
	public String deleteCategory(int categoryId) throws CategoryException {
		if(bookStoreDao.categoryExists(categoryId)) {
			bookStoreDao.deleteCategory(categoryId);
			return BookStoreConstants.CATEGORY_DELETED;
		}
		throw new CategoryException(BookStoreConstants.CATEGORY_DOES_NOT_EXIST);
	}

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



	
}