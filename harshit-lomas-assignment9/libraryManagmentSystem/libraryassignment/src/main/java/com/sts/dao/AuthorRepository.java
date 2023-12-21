package com.sts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sts.entities.Author;


public interface AuthorRepository extends CrudRepository<Author,Integer> {

	@Query("from Author")
	public List<Author> getAllAuthors();
}
