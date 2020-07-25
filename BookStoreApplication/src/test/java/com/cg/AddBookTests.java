/*package com.cg;
 
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

import com.cg.bookStore.entities.BookInformation;
import com.cg.bookStore.service.ManageBookService;
import com.cg.bookStore.web.ManageBookController;

/**************************************************************************************************
*          @author         Rohita
*          Description     Test class for controller functions.
*          Version             2.0
*          Created Date    17-July-2020
**************************************************************************************************/
/*@RunWith(SpringRunner.class)
@WebMvcTest(value = ManageBookController.class)
public class AddBookTests {
	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	private ManageBookService service;
	
	@Test
	public void testCreateBookNull() throws Exception {
		String categoryJson = "{\"title\":\"\","
				+ "\"author\":\"JK Rowling\","
				+ "\"description\":\"The primary argument supporting cell phone control in the classroom is the fact that phones can be distracting. Not only do cell phones distract instructors, but they may also distract students trying to pay attention to the lecture. This is the same effect as a moviegoer looking at his phone in a theater. Even if the phone makes no noise, the light from the screen is enough to catch someone’s attention.Arguments against cell phone control typically focus on safety concerns. Should a crisis occurs in the classroom, students should have their phones on hand to make a call. If a student has a child, he or she may need a phone in case of a medical emergency. If the student is on call for work, he or she will need access to a phone. The list of exception-worthy scenarios is endless.The best solution is to create cell phone usage rules that allow devices to be accessible without disturbing other students’ educational opportunities. Students should be permitted to keep their phones in their bags, pockets, or other belongings as lo\","
				+ "\"price\":\"200\","
				+ "\"isbnNumber\":\"123456789123\","
				+ "\"publishDate\":\"2020-03-12\","
				+ "\"lastUpdateTime\":\"2020-07-17\"}";
		String expectedResult="Cannot add empty book title";
		Mockito.when(
				service.createBook(Mockito.any(BookInformation.class))).thenReturn(expectedResult);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/manageBook/create").accept(MediaType.APPLICATION_JSON).content(categoryJson).contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string("Cannot add empty book title")).andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testCreateBookNull1() throws Exception {
		String categoryJson ="{\"title\":\"Harry Potter\",\"author\":\"\",\"description\":\"The primary argument supporting cell phone control in the classroom is the fact that phones can be distracting. Not only do cell phones distract instructors, but they may also distract students trying to pay attention to the lecture. This is the same effect as a moviegoer looking at his phone in a theater. Even if the phone makes no noise, the light from the screen is enough to catch someone’s attention.Arguments against cell phone control typically focus on safety concerns. Should a crisis occurs in the classroom, students should have their phones on hand to make a call. If a student has a child, he or she may need a phone in case of a medical emergency. If the student is on call for work, he or she will need access to a phone. The list of exception-worthy scenarios is endless.The best solution is to create cell phone usage rules that allow devices to be accessible without disturbing other students’ educational opportunities. Students should be permitted to keep their phones in their bags, pockets, or other belongings as lo\",\"price\":\"200\",\"isbnNumber\":\"123456789123\",\"publishDate\":\"2020-03-12\",\"lastUpdateTime\":\"2020-07-17\"}";
		String expectedResult="Cannot add empty author name";
		Mockito.when(
				service.createBook(Mockito.any(BookInformation.class))).thenReturn(expectedResult);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/manageBook/create").accept(MediaType.APPLICATION_JSON).content(categoryJson).contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string("Cannot add empty author name")).andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testCreateBookNull2() throws Exception {
		String categoryJson = "{\"title\":\"Harry Potter\",\"author\":\"JK Rowling\",\"description\":\"\",\"price\":\"200\",\"isbnNumber\":\"123456789123\",\"publishDate\":\"2020-03-12\",\"lastUpdateTime\":\"2020-07-17\"}";
		String expectedResult="Cannot add empty description";
		Mockito.when(
				service.createBook(Mockito.any(BookInformation.class))).thenReturn(expectedResult);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/manageBook/create").accept(MediaType.APPLICATION_JSON).content(categoryJson).contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string("Cannot add empty description")).andDo(MockMvcResultHandlers.print());
	}
	
	
	
	@Test
	public void testCreateBookNull4() throws Exception {
		String categoryJson = "{\"title\":\"Harry Potter\",\"author\":\"JK Rowling\",\"description\":\"The primary argument supporting cell phone control in the classroom is the fact that phones can be distracting. Not only do cell phones distract instructors, but they may also distract students trying to pay attention to the lecture. This is the same effect as a moviegoer looking at his phone in a theater. Even if the phone makes no noise, the light from the screen is enough to catch someone’s attention.Arguments against cell phone control typically focus on safety concerns. Should a crisis occurs in the classroom, students should have their phones on hand to make a call. If a student has a child, he or she may need a phone in case of a medical emergency. If the student is on call for work, he or she will need access to a phone. The list of exception-worthy scenarios is endless.The best solution is to create cell phone usage rules that allow devices to be accessible without disturbing other students’ educational opportunities. Students should be permitted to keep their phones in their bags, pockets, or other belongings as lo\",\"price\":\"200\",\"isbnNumber\":\"\",\"publishDate\":\"2020-03-12\",\"lastUpdateTime\":\"2020-07-17\"}";
		String expectedResult="Cannot add empty ISBN number";
		Mockito.when(
				service.createBook(Mockito.any(BookInformation.class))).thenReturn(expectedResult);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/manageBook/create").accept(MediaType.APPLICATION_JSON).content(categoryJson).contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string("Cannot add empty ISBN number")).andDo(MockMvcResultHandlers.print());
	}
	
	
	
	@Test
	public void testCreateBookBotValidated() throws Exception {
		String categoryJson = "{\"title\":\"Har\",\"author\":\"JK Rowling\",\"description\":\"The primary argument supporting cell phone control in the classroom is the fact that phones can be distracting. Not only do cell phones distract instructors, but they may also distract students trying to pay attention to the lecture. This is the same effect as a moviegoer looking at his phone in a theater. Even if the phone makes no noise, the light from the screen is enough to catch someone’s attention.Arguments against cell phone control typically focus on safety concerns. Should a crisis occurs in the classroom, students should have their phones on hand to make a call. If a student has a child, he or she may need a phone in case of a medical emergency. If the student is on call for work, he or she will need access to a phone. The list of exception-worthy scenarios is endless.The best solution is to create cell phone usage rules that allow devices to be accessible without disturbing other students’ educational opportunities. Students should be permitted to keep their phones in their bags, pockets, or other belongings as lo\",\"price\":\"200\",\"isbnNumber\":\"123456789123\",\"publishDate\":\"2020-03-12\",\"lastUpdateTime\":\"2020-07-17\"}";
		String expectedResult="Title name cannot be less than 5 characters and more than 30";
		Mockito.when(
				service.createBook(Mockito.any(BookInformation.class))).thenReturn(expectedResult);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/manageBook/create").accept(MediaType.APPLICATION_JSON).content(categoryJson).contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string("Title name cannot be less than 5 characters and more than 30")).andDo(MockMvcResultHandlers.print());
	
	
}
	@Test
	public void testCreateBookBotValidated1() throws Exception {
		String categoryJson = "{\"title\":\"Harry Potter\",\"author\":\"JK \",\"description\":\"The primary argument supporting cell phone control in the classroom is the fact that phones can be distracting. Not only do cell phones distract instructors, but they may also distract students trying to pay attention to the lecture. This is the same effect as a moviegoer looking at his phone in a theater. Even if the phone makes no noise, the light from the screen is enough to catch someone’s attention.Arguments against cell phone control typically focus on safety concerns. Should a crisis occurs in the classroom, students should have their phones on hand to make a call. If a student has a child, he or she may need a phone in case of a medical emergency. If the student is on call for work, he or she will need access to a phone. The list of exception-worthy scenarios is endless.The best solution is to create cell phone usage rules that allow devices to be accessible without disturbing other students’ educational opportunities. Students should be permitted to keep their phones in their bags, pockets, or other belongings as lo\",\"price\":\"200\",\"isbnNumber\":\"123456789123\",\"publishDate\":\"2020-03-12\",\"lastUpdateTime\":\"2020-07-17\"}";
		String expectedResult="author name cannot be less than 5 characters and more than 64";
		Mockito.when(
				service.createBook(Mockito.any(BookInformation.class))).thenReturn(expectedResult);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/manageBook/create").accept(MediaType.APPLICATION_JSON).content(categoryJson).contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string("author name cannot be less than 5 characters and more than 64")).andDo(MockMvcResultHandlers.print());
	
		
	
}
	@Test
	public void testCreateBookBotValidated2() throws Exception {
		String categoryJson = "{\"title\":\"Harry Potter\",\"author\":\"JK Rowling \",\"description\":\"The primary argument supporting cell phone control in the classroom is the fact that phones can be distracting. Not only do cell phones distract instructors, but they may also distract students trying to pay attention to the lecture. This is the same effect as a moviegoer looking at his phone in a theater. Even if the phone makes no noise, the light from the screen is enough to catch someone’s attention.Arguments against cell phone control typically focus on safety concerns. Should a crisis occurs in the classroom, students should have their phones on hand to make a call. If a student has a child, he or she may need a phone in case of a medical emergency. If the student is on call for work, he or she will need access to a phone. The list of exception-worthy scenarios is endless.The best solution is to create cell phone usage rules that allow devices to be accessible without disturbing other students’ educational opportunities. Students should be permitted to keep their phones in their bags, pockets, or other belongings as lo\",\"price\":\"200\",\"isbnNumber\":\"123\",\"publishDate\":\"2020-03-12\",\"lastUpdateTime\":\"2020-07-17\"}";
		String expectedResult="ISBN number cannot be less than 10 characters and more than 15";
		Mockito.when(
				service.createBook(Mockito.any(BookInformation.class))).thenReturn(expectedResult);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/manageBook/create").accept(MediaType.APPLICATION_JSON).content(categoryJson).contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string("ISBN number cannot be less than 10 characters and more than 15")).andDo(MockMvcResultHandlers.print());
	
		
	
}
	@Test
	public void testCreateBookBotValidated3() throws Exception {
		String categoryJson = "{\"title\":\"Harry Potter\",\"author\":\"JK Rowling \",\"description\":\"The primary argument supporting cell phone control in the classroom is the fact that phones can be distracting. Not only do cell phones distract instructors, but they may also distract students trying to pay attention to the lecture. This is the same effect as a moviegoer looking at his phone in a theater. Even if the phone makes no noise, the light from the screen is enough to catch someone’s attention.Arguments against cell phone control typically focus on safety concerns. Should a crisis occurs in the classroom, students should have their phones on hand to make a call. If a student has a child, he or she may need a phone in case of a medical emergency. If the student is on call for work, he or she will need access to a phone. The list of exception-worthy scenarios is endless.The best solution is to create cell phone usage rules that allow devices to be accessible without disturbing other students’ educational opportunities. Students should be permitted to keep their phones in their bags, pockets, or other belongings as lo\",\"price\":\"200\",\"isbnNumber\":\"123456789123456789\",\"publishDate\":\"2020-03-12\",\"lastUpdateTime\":\"2020-07-17\"}";
		String expectedResult="ISBN number cannot be less than 10 characters and more than 15";
		Mockito.when(
				service.createBook(Mockito.any(BookInformation.class))).thenReturn(expectedResult);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/manageBook/create").accept(MediaType.APPLICATION_JSON).content(categoryJson).contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string("ISBN number cannot be less than 10 characters and more than 15")).andDo(MockMvcResultHandlers.print());
}
	
	@Test
	public void testCreateBookAdded() throws Exception {
		String categoryJson = "{\"title\":\"Harry Potter\",\"author\":\"JK Rowling \",\"description\":\"The primary argument supporting cell phone control in the classroom is the fact that phones can be distracting. Not only do cell phones distract instructors, but they may also distract students trying to pay attention to the lecture. This is the same effect as a moviegoer looking at his phone in a theater. Even if the phone makes no noise, the light from the screen is enough to catch someone’s attention.Arguments against cell phone control typically focus on safety concerns. Should a crisis occurs in the classroom, students should have their phones on hand to make a call. If a student has a child, he or she may need a phone in case of a medical emergency. If the student is on call for work, he or she will need access to a phone. The list of exception-worthy scenarios is endless.The best solution is to create cell phone usage rules that allow devices to be accessible without disturbing other students’ educational opportunities. Students should be permitted to keep their phones in their bags, pockets, or other belongings as lo\",\"price\":\"200\",\"isbnNumber\":\"1234567891234\",\"publishDate\":\"2020-03-12\",\"lastUpdateTime\":\"2020-07-17\"}";
		String expectedResult="book added";
		Mockito.when(
				service.createBook(Mockito.any(BookInformation.class))).thenReturn(expectedResult);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/manageBook/create").accept(MediaType.APPLICATION_JSON).content(categoryJson).contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string("book added")).andDo(MockMvcResultHandlers.print());
	}
}*/