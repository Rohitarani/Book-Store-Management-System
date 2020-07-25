package com.cg.bookStore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.entities.BookInformation;

/**************************************************************************************************
*          @author         Rohita, Aishwarya, Amardeep, Sachin, Vainkatesh, Abhilash, Shashwat
*          Description      This class implements the BookStoreDao interface.
*          Version             2.0
*          Created Date    17-July-2020
**************************************************************************************************/
@Repository
public class BookStoreDaoImpl implements BookStoreDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean createCategory(BookCategory category){
		entityManager.persist(category);
		return true;
	}
	
	public boolean categoryExists(String categoryName) {
		String jpql = "from BookCategory b where b.categoryName=:cName";
		TypedQuery<BookCategory> query = entityManager.createQuery(jpql, BookCategory.class);
		query.setParameter("cName",categoryName);
	    List<BookCategory> existingCat = query.getResultList();
	    if(existingCat.isEmpty()) {
	    	return false;
	    }
	    return true;
	}
	
	
	
	@Override
	public BookCategory viewCategory(Integer categoryId) {
		
		return entityManager.find(BookCategory.class,categoryId);
	}
	
	public boolean categoryExists(int categoryId) {
		String jpql = "from BookCategory b where b.categoryId=:cId";
		TypedQuery<BookCategory> query = entityManager.createQuery(jpql, BookCategory.class);
		query.setParameter("cId",categoryId);
	    List<BookCategory> existingCat = query.getResultList();
	    if(existingCat.isEmpty()) {
	    	return false;
	    }
	    return true;
	}
	
	public boolean bookExists(int bookId) {
		String jpql = "from BookInformation b where b.bookId=:bId";
		TypedQuery<BookInformation> query = entityManager.createQuery(jpql, BookInformation.class);
		query.setParameter("bId",bookId);
	    List<BookInformation> existingCat = query.getResultList();
	    if(existingCat.isEmpty()) {
	    	return false;
	    }
	    return true;
	}

	@Override
	public boolean deleteBook(int bookId) {
		BookInformation book = entityManager.find(BookInformation.class,bookId);
		entityManager.remove(book);
		return true;
	}
	

	@Override
	public boolean addBook(BookInformation bookInfo) {
		entityManager.persist(bookInfo);
		return true;
	}
	
	public List<BookInformation> listAllBooks() {
		String Qstr="SELECT bookInformation FROM BookInformation bookInformation ORDER BY bookInformation.title ASC";
		TypedQuery<BookInformation> query=entityManager.createQuery(Qstr,BookInformation.class);
		List<BookInformation> listAllBooks=query.getResultList();
		return listAllBooks;
	}

	@Override
	public boolean updateBookInfo(BookInformation book) {
		String str="update BookInformation bookInfo set bookInfo.title=:title,bookInfo.author=:author,"
				+ "bookInfo.description=:description,bookInfo.isbnNumber=:isbnNumber,bookInfo.publishDate=:publishDate,"
				+ "bookInfo.lastUpdateTime=:lastUpdateTime,bookInfo.price=:price where bookInfo.bookId=:id";
		Query query=entityManager.createQuery(str);
		query.setParameter("title", book.getTitle());
		query.setParameter("author", book.getAuthor());
		query.setParameter("description", book.getDescription());
		query.setParameter("isbnNumber", book.getIsbnNumber());
		query.setParameter("publishDate", null);
		query.setParameter("lastUpdateTime",null);
		query.setParameter("price", book.getPrice());
		query.setParameter("id", book.getBookId());
		query.executeUpdate();
		return true;	
	}

	@Override
	public boolean updateCategory(BookCategory category) {
		String str="SELECT category FROM BookCategory category WHERE category.categoryName=:newCategoryName";
		TypedQuery<BookCategory> query=entityManager.createQuery(str,BookCategory.class);
		query.setParameter("newCategoryName", category.getCategoryName());
		try {
			query.getSingleResult();
		}catch(NoResultException e) {
			entityManager.merge(category);
			return true;
		}
		return false;
	}
	
	public boolean deleteCategory(int categoryId) {
			BookCategory category = entityManager.find(BookCategory.class,categoryId);
			entityManager.remove(category);
			return true;
	}
	
	public boolean bookExists(String bookName) {
		String jpql = "from BookInformation b where b.title=:cName";
		TypedQuery<BookInformation> query = entityManager.createQuery(jpql, BookInformation.class);
		query.setParameter("cName",bookName);
	    List<BookInformation> existingCat = query.getResultList();
	    if(existingCat.isEmpty()) {
	    	return false;
	    }
	    return true;
	}
	
	@Override
	public List<BookCategory> listAllCategory() {
		
		String qstr="Select b from BookCategory b";
		TypedQuery<BookCategory> query=entityManager.createQuery(qstr,BookCategory.class);
		return query.getResultList();
	}
	
	@Override
	public boolean categoryContainsBook(int categoryId) {
		
		BookCategory category=entityManager.find(BookCategory.class, categoryId);
		String jpql = "from BookInformation b where b.category=:category";
		TypedQuery<BookInformation> query = entityManager.createQuery(jpql, BookInformation.class);
		query.setParameter("category",category);
	    List<BookInformation> existingCat = query.getResultList();
	    return existingCat.isEmpty();
	    	
	}

}