package com.cg.bookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.cg.bookStore.entities.BookInformation;
import com.cg.bookStore.exceptions.BookException;
import com.cg.bookStore.service.ManageBookService;

@Controller
public class ManageBookController {

	@Autowired
	private ManageBookService service;
	
	@GetMapping("/manageBook/delete/{bookId}")
	public String deleteBook(@PathVariable(name="bookId") int bookId) throws BookException {
		return service.deleteBook(bookId);
	}
	
	@PostMapping("/manageBook/create")
	public String createBook(@RequestBody BookInformation book) throws BookException {
		return service.createBook(book);
	}
	
	@PostMapping("manageBook/update")
	public String updateBook(@RequestBody  BookInformation book) throws BookException {
		return service.updateBook(book);
	}
	
	@GetMapping("manageBook/display/{bookId}")
	public String displayBook(@PathVariable(name="bookId") int bookId) throws BookException {
		return service.displayBook(bookId);
	}
}
