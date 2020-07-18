package com.cg.bookStore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.entities.BookInformation;
import com.cg.bookStore.exceptions.BookException;
import com.cg.bookStore.service.ManageBookService;

@RestController
public class ManageBookController {

	@Autowired
	private ManageBookService bookStoreService;
	
	@DeleteMapping("/manageBook/delete/{bookId}")
	public String deleteBook(@PathVariable(name="bookId") int bookId) throws BookException {
		return bookStoreService.deleteBook(bookId);
	}
	
	@PostMapping("/manageBook/create")
	public String createBook(@RequestBody BookInformation book) throws BookException {
		return bookStoreService.createBook(book);
	}
	
	@PostMapping("/manageBook/update")
	public String updateBook(@RequestBody  BookInformation book) throws BookException {
		return bookStoreService.updateBook(book);
	}
	
	@GetMapping("/manageBook/display")
	public List<BookInformation> displayBooks() throws BookException {
		return bookStoreService.displayBooks();
	}
}