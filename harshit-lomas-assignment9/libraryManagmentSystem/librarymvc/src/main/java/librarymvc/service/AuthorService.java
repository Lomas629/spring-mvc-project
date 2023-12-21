package librarymvc.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import librarymvc.dao.ExtractData;
import librarymvc.model.Author;

@Service
public class AuthorService {
	
	@Autowired
	private ExtractData api; 
	
	public List<Author> getAllAuthors() throws IOException, InterruptedException {
		return api.getAuthors();
	}

}
