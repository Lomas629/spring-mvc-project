package com.sts.service;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.dao.BookRepository;
import com.sts.entities.Books;

@Service
public class BookService {

	@Autowired
	private BookRepository dao;
	
	public Books addBook(Books book) {
//		Date currentDate = new Date();
//	    String dateTime = DateFormat.getDateInstance().format(currentDate);
//	    book.setDateadded(dateTime);
	    
		Books savedBook = this.dao.save(book);
		return savedBook;
	}
	

	public Books findBookById(int id) {
		Optional<Books> book = this.dao.findById(id);
		Books result = book.get();
		return result;
	}
	
	public Books updateBook(int id,Books book) {
		Date currentDate = new Date();
	    String dateTime = DateFormat.getDateInstance().format(currentDate);
	    
		Optional<Books> bookById = this.dao.findById(id);
		Books bookresult = bookById.get();
		
		bookresult.setName(book.getName());
		bookresult.setDateadded(book.getDateadded());
		bookresult.setAuthor(book.getAuthor());
		
		Books updatedBook = this.dao.save(bookresult);
		
		return updatedBook;
	}
	

	public void deleteBook(int id) {
		Optional<Books> bookById = this.dao.findById(id);
		Books bookresult = bookById.get();
		
		this.dao.delete(bookresult);
		
	}
	
	public List<Books> allBooks() {
		List<Books> books = (List<Books>) this.dao.getAllBooks();
		return books;
	}
	
	
}
