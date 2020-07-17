package com.cg.bookStore.service;

import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.exceptions.CategoryException;

public interface ManageCategoryService {

	public String createCategory(BookCategory category) throws CategoryException;
}
