package com.sts.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sts.entities.Librarian;

public interface LibrarianRepository extends CrudRepository<Librarian,Integer> {
	
	@Query("from Librarian where name=:nameParam and password=:passwordParam")
	public Librarian findLibrarian(@Param("nameParam") String name,@Param("passwordParam") String password);
	
}
