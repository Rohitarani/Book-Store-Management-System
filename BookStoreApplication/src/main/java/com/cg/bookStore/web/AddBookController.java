package com.cg.bookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.dto.AddBookForm;
import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.entities.BookInformation;
import com.cg.bookStore.exceptions.CategoryException;
import com.cg.bookStore.service.AddBookService;
import com.cg.bookStore.service.ManageCategoryService;

@RestController
public class AddBookController {
	
	@Autowired
	private AddBookService service;
	
	

	@PostMapping("/addbook/create")
	public String addBookinfo(@RequestBody BookInformation bookinfo) throws CategoryException {
		return service.addBook(bookinfo);
		
	}
}
