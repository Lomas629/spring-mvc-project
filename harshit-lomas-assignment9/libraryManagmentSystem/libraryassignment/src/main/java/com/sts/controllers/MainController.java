package com.sts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sts.entities.Author;
import com.sts.entities.Books;
import com.sts.entities.Librarian;
import com.sts.service.AuthorService;
import com.sts.service.BookService;
import com.sts.service.LibrarianService;

@RestController
public class MainController {
	
	@Autowired
	BookService bookservice;
	
	@Autowired
	LibrarianService libservice;
	
	@Autowired
	AuthorService authorservice;
	
//-------------------------------------------------------------------------
	//test routes
//-------------------------------------------------------------------------
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return "this is test page";
	}
	
//-------------------------------------------------------------------------
	//librarian routes
//-------------------------------------------------------------------------
	
	@GetMapping("/login")
	@ResponseBody
	public Librarian login(@RequestBody Librarian librarian) {
		String name = librarian.getName();
		String password = librarian.getPassword();
		
		Librarian result = this.libservice.find(name,password);
		return result;
	}
	
	@PostMapping("/register")
	public Librarian register(@RequestBody Librarian librarian) {
		Librarian savedresult = this.libservice.addLibrarian(librarian);
		return savedresult;
	}
	
	@GetMapping("/allLibrarians")
	public List<Librarian> allLibrarians() {
		
		List<Librarian> librarians = this.libservice.allLibrarians();
		return librarians;
		
	}
	
//--------------------------------------------------------------------------------	
	//book management routes
//---------------------------------------------------------------------------------	

	@GetMapping("/book/{id}")
	@ResponseBody
	public Books getBook(@PathVariable("id") int id) {
		  return this.bookservice.findBookById(id);
	}
	
	@PostMapping("/add")
	@ResponseBody
	public Books saveUser(@RequestBody Books book) {
		Books savedBook = this.bookservice.addBook(book);
		System.out.println(savedBook);
		return savedBook;
	}
	
	@PutMapping("/books/{bookId}")
	public Books updateBook(@PathVariable("bookId") int bookId,@RequestBody Books book) {
		return this.bookservice.updateBook(bookId, book);
	}
	
	@DeleteMapping("/deletebook/{bookId}")
	@ResponseBody
	public String deleteBook(@PathVariable("bookId") int bookId) {
		this.bookservice.deleteBook(bookId);
		return "data is successfully deleted";
	}
	
	@GetMapping("/books")
	@ResponseBody
	public List<Books> allBooks() {
		return this.bookservice.allBooks();
	}
	
	//-----------------------------------------------------------------------------------
	// Author routes
	//-----------------------------------------------------------------------------------
	
	@PostMapping("/addauthor")
	@ResponseBody
	public Author saveAuthor(@RequestBody Author author) {
		return this.authorservice.saveAuthor(author);
	}
	
	@GetMapping("/allauthors")
	@ResponseBody
	public List<Author> getAllAuthors() {
		return this.authorservice.getAll();
	}

}
