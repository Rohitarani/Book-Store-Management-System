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
public class CreateCategoryTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ManageCategoryService service;
	
	@Test
	public void testCreateCategoryNull() throws Exception {
		String categoryJson = "{\"categoryName\":\"\"}";
		String expectedResult="Cannot add empty category";
		Mockito.when(
				service.createCategory(Mockito.any(BookCategory.class))).thenReturn(expectedResult);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/manageCategory/create").accept(MediaType.APPLICATION_JSON).content(categoryJson).contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string("Cannot add empty category")).andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testCreateCategoryExists() throws Exception {
		String categoryJson = "{\"categoryName\":\"shashwat\"}";
		String expectedResult="Category already exists";
		Mockito.when(
				service.createCategory(Mockito.any(BookCategory.class))).thenReturn(expectedResult);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/manageCategory/create").accept(MediaType.APPLICATION_JSON).content(categoryJson).contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string("Category already exists")).andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testCreateCategoryBotValidated() throws Exception {
		String categoryJson = "{\"categoryName\":\"Thriller\"}";
		String expectedResult="Category name cannot be less than 5 characters and more than 30";
		Mockito.when(
				service.createCategory(Mockito.any(BookCategory.class))).thenReturn(expectedResult);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/manageCategory/create").accept(MediaType.APPLICATION_JSON).content(categoryJson).contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string("Category name cannot be less than 5 characters and more than 30")).andDo(MockMvcResultHandlers.print());
	} 
	
	
	@Test
	public void testCreateCategoryAdded() throws Exception {
		String categoryJson = "{\"categoryName\":\"Thriller\"}";
		String expectedResult="Category added";
		Mockito.when(
				service.createCategory(Mockito.any(BookCategory.class))).thenReturn(expectedResult);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/manageCategory/create").accept(MediaType.APPLICATION_JSON).content(categoryJson).contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string("Category added")).andDo(MockMvcResultHandlers.print());
	}

}
