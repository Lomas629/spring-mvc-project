package com.sts.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.dao.LibrarianRepository;
import com.sts.entities.Librarian;

@Service
public class LibrarianService {
	
	@Autowired
	private LibrarianRepository dao;
	
	public Librarian find(String name,String password) {
		Librarian result = this.dao.findLibrarian(name, password);
		return result;
	}
	
	public Librarian addLibrarian(Librarian librarian) {
		Librarian savedLibrarian = this.dao.save(librarian);
		return savedLibrarian;
	}
	
	public List<Librarian> allLibrarians(){
		List<Librarian> list = (List<Librarian>) this.dao.findAll();
		return list;
	}
	
}
