package com.sts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sts.entities.Books;


public interface BookRepository extends CrudRepository<Books,Integer> {
	
	@Query("from Books")
	public List<Books> getAllBooks();
	
}
