package com.cg.bookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.exceptions.CategoryException;
import com.cg.bookStore.service.ManageCategoryService;

@RestController
public class ManageCategoryController {

	@Autowired
	private ManageCategoryService service;
	
	@PostMapping("/manageCategory/create")
	public String createCategory(@RequestBody BookCategory category) throws CategoryException {
		return service.createCategory(category);
	}
}