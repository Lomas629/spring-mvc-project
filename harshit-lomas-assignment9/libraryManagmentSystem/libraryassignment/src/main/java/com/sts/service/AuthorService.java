package com.sts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.dao.AuthorRepository;
import com.sts.entities.Author;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository dao;
	
	public Author saveAuthor(Author author) {
		Author savedAuthor = this.dao.save(author);
		return savedAuthor;
	}
	
	public List<Author> getAll() {
		List<Author> list = this.dao.getAllAuthors();
		return list;
	}
	
}
