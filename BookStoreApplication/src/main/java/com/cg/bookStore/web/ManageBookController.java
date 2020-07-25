package com.cg.bookStore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.dto.BookForm;
import com.cg.bookStore.dto.ResponseMessage;
import com.cg.bookStore.entities.BookInformation;
import com.cg.bookStore.exceptions.BookException;
import com.cg.bookStore.service.ManageBookService;

/**************************************************************************************************
 *          @author         Rohita, Aishwarya, Amardeep, Sachin
 *          Description      It is a controller class having Request Mapping functions
 *          				 for functionalities of Manage books.
 *          Version             2.0
 *          Created Date    17-July-2020
 **************************************************************************************************/
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ManageBookController {

	@Autowired
	private ManageBookService bookStoreService;
	
	/*******************************************
	 * Method: deleteBook
     *Description: To take a delete request to delete book, return message.. 
	 * @param name              - bookId.
	 * @returns shows(String)   - Message that book deleted or not
	 * @throws BookException - When that book does not exists in database, exception is thrown. 
                *Created By                              - Aishwarya srivastava
                *Created Date                            - 17-Jul-2020                           	 
	 ********************************************/
	
	@DeleteMapping("/manageBook/delete/{bookId}")
	public ResponseMessage deleteBook(@PathVariable(name="bookId") int bookId) throws BookException {
		ResponseMessage message = new ResponseMessage();
		message.setMessage(bookStoreService.deleteBook(bookId));
		return message;
	}
	
	
	/*******************************************
	 * Method: createBook
     *Description: To take a post request to create book, return message.. 
	 * @param name              - book.
	 * @returns shows(String)   - Message that book added or not
	 * @throws BookException - When that book does already exists in database, exception is thrown. 
                *Created By                              - Rohita Rani
                *Created Date                            - 17-Jul-2020                           	 
	 ********************************************/
	
	
	
	
	@PostMapping("/manageBook/create")
	public ResponseMessage createBook(@RequestBody BookForm book) throws BookException {
		ResponseMessage message = new ResponseMessage();
		message.setMessage(bookStoreService.createBook(book));
		return message;

	}
	
	
	/*******************************************
	 * Method: updateBook
     *Description: To take a update request to update book, return message.. 
	 * @param name              - book.
	 * @returns shows(String)   - Message that book update or not
	 * @throws BookException - When that book does already exists/ or not in database, exception is thrown. 
                *Created By                              - Sachin kumar
                *Created Date                            - 17-Jul-2020                           	 
	 ********************************************/
	@PostMapping("/manageBook/update")
	public ResponseMessage updateBook(@RequestBody  BookInformation book) throws BookException {
		ResponseMessage message = new ResponseMessage();
		message.setMessage(bookStoreService.updateBook(book));
		return message;

	}
	
	/*******************************************
	 * Method: displayBooks
     *Description: To take a get request to display all books in database. 
	 * @returns List<BookInformation>   - List of all books in database
	 * @throws BookException - When no book  exists in database, exception is thrown. 
                *Created By                              - Amardeep
                *Created Date                            - 17-Jul-2020                           	 
	 ********************************************/
	@GetMapping("/manageBook/displayAllBook")
	public List<BookInformation> displayBooks() throws BookException {
		return bookStoreService.displayBooks();
	}
}