package com.cg.bookStore.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookStore.dao.BookStoreDao;
import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.exceptions.CategoryException;

@Service
@Transactional
public class ManageCategoryServiceImpl implements ManageCategoryService{

	@Autowired
	private BookStoreDao dao;
	
	@Override
	public String createCategory(BookCategory category) throws CategoryException {
		String categoryName = category.getCategoryName();
		categoryName = categoryName.toLowerCase();
		
		if(categoryName.isEmpty()) {
			throw new CategoryException("Cannot add empty category");
		}
		
		if(categoryName.length()<5 || categoryName.length()>30) {
			throw new CategoryException("Category name cannot be less than 5 characters and more than 30");
		}
		
		if(dao.findCategory(categoryName)) {
			throw new CategoryException("Category already exists");
		}
		
		dao.createCategory(category);
		return "Category added";
		
		
	}
}