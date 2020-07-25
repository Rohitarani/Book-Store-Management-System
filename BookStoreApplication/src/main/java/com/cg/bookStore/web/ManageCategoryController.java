package com.cg.bookStore.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.dto.ResponseMessage;
import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.exceptions.CategoryException;
import com.cg.bookStore.service.ManageCategoryService;

/**************************************************************************************************
 *          @author         Vainkatesh, Shashwat, Abhilash
 *          Description      It is a controller class having Request Mapping functions
 *          				 for functionalities of Manage categories.
 *          Version             2.0
 *          Created Date    17-July-2020
 **************************************************************************************************/
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ManageCategoryController {

	@Autowired
	private ManageCategoryService bookStoreService;
	
	/*******************************************
	 * Method: createCategory
     *Description: To take a post request to create category, return message.. 
	 * @param name              - category.
	 * @returns shows(String)   - Message that category added or not
	 * @throws CategoryException - When that category does already exists in database, exception is thrown. 
                *Created By                              - Shashwat khare
                *Created Date                            - 17-Jul-2020                           	 
	 ********************************************/
	@PostMapping("/manageCategory/create")
	public ResponseMessage createCategory(@RequestBody BookCategory category) throws CategoryException {
		ResponseMessage message = new ResponseMessage();
		message.setMessage(bookStoreService.createCategory(category));
		return message;
	}

	/*******************************************
	 * Method: deleteCategory
     *Description: To take a delete request to delete category, return message.. 
	 * @param name              - categoryId.
	 * @returns shows(String)   - Message that category deleted or not
	 * @throws CategoryException - When that category does not exists in database, exception is thrown. 
                *Created By                              - Abhilash Mishra
                *Created Date                            - 17-Jul-2020                           	 
	 ********************************************/
	@DeleteMapping("/manageCategory/delete/{categoryId}")
	public ResponseMessage deleteCategory(@PathVariable(name="categoryId") int categoryId) throws CategoryException {
		ResponseMessage message = new ResponseMessage();
		message.setMessage(bookStoreService.deleteCategory(categoryId));
		return message;
	}
	
	/*******************************************
	 * Method: updateCategory
     *Description: To take a put request to update category, return message.. 
	 * @param name              - category.
	 * @returns shows(String)   - Message that category added or not
	 * @throws CategoryException - When that category does not exists in database, exception is thrown. 
                *Created By                              - Vainkatesh prasad jangid
                *Created Date                            - 17-Jul-2020                           	 
	 ********************************************/
	@PutMapping("/manageCategory/update")
	public ResponseMessage updateCategory(@RequestBody BookCategory category) throws CategoryException {
		ResponseMessage message = new ResponseMessage();
		message.setMessage(bookStoreService.updateCategory(category));
		return message;
	}
	
	/*******************************************
	 * Method: displayAllCategory
     *Description: To return a list of all categories in database.  
	 * @returns List<BookCategory>   - List all all categories
	 * @throws CategoryException - No category, exception is thrown. 
                *Created By                              - Abhilash Mishra
                *Created Date                            - 19-Jul-2020                           	 
	 ********************************************/
	@GetMapping("/manageCategory/displayAllCategory")
	public List<BookCategory> displayAllCategory() throws CategoryException{
		return bookStoreService.listAllCategory();
	}
}