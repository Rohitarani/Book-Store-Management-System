package com.cg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.service.ManageCategoryService;
import com.cg.bookStore.web.ManageCategoryController;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ManageCategoryController.class)
public class UpdateCategoryTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ManageCategoryService service;
	
	@Test
	public void testUpdateCategoryNull() throws Exception {
		String categoryJson = "{\"categoryId\":100,"
				+ "\"categoryName\":\"\"}";
		String expectedResult="Category name is required";
		
		Mockito.when(
				service.updateCategory(Mockito.any(BookCategory.class))).thenReturn(expectedResult);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/manageCategory/update").accept(MediaType.APPLICATION_JSON).content(categoryJson).contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string("Category name is required")).andDo(MockMvcResultHandlers.print());
		
	}
	
	
	@Test
	public void testUpdateCategoryAlreadyExists() throws Exception {
		String categoryJson = "{\"categoryId\":100,"
				+ "\"categoryName\":\"Self Help\"}";
		String expectedResult="Error:There is already a category with this name";
		Mockito.when(
				service.createCategory(Mockito.any(BookCategory.class))).thenReturn(expectedResult);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/manageCategory/update").accept(MediaType.APPLICATION_JSON).content(categoryJson).contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string("Error:There is already a category with this name")).andDo(MockMvcResultHandlers.print());
	}
	
	
	@Test
	public void testUpdateCategoryUpdated() throws Exception {
		String categoryJson = "{\"categoryId\":100,"
				+ "\"categoryName\":\"Thriller\"}";
		String expectedResult="Category updated successfully";
		Mockito.when(
				service.createCategory(Mockito.any(BookCategory.class))).thenReturn(expectedResult);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/manageCategory/update").accept(MediaType.APPLICATION_JSON).content(categoryJson).contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string("Category updatd successfully")).andDo(MockMvcResultHandlers.print());
	}

}