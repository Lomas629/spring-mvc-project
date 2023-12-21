package librarymvc.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import librarymvc.dao.ExtractData;
import librarymvc.model.Books;

@Service
public class BookService {
	
	@Autowired
	private ExtractData api; 

	public List<Books> fetchAllBooks() throws IOException, InterruptedException {
		return api.getBooks();
	}
	
	public void postData(Books book) throws IOException, InterruptedException {
		this.api.postData(book);
	}

	public void editBookdetails(int id, Books book) throws IOException, InterruptedException {
		this.api.editBookData(id,book);
	}

	public void deleteBook(Integer id) throws IOException, InterruptedException {
		this.api.deleteBook(id);
	}

}
