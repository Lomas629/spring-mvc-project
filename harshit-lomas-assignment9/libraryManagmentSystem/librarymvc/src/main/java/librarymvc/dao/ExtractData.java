package librarymvc.dao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import librarymvc.model.Author;
import librarymvc.model.Books;

@Component
public class ExtractData {

	public boolean check(String name, String password) throws IOException, InterruptedException {

		String url = "http://localhost:8890/allLibrarians";

		HttpRequest req = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		HttpClient client = HttpClient.newBuilder().build();
		HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
		ObjectMapper mapper = new ObjectMapper();

		JsonNode newJson = mapper.readValue(res.body(), JsonNode.class);

		for (JsonNode node : newJson) {
			String username = node.get("name").toString().replace("\"", "");
			String fetchedpassword = node.get("password").toString().replace("\"", "");
			;

			if (username.equalsIgnoreCase(name) && fetchedpassword.equalsIgnoreCase(password))
				return true;

		}

		return false;
	}

	public List<Books> getBooks() throws IOException, InterruptedException {

		String url = "http://localhost:8890/books";

		HttpRequest req = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		HttpClient client = HttpClient.newBuilder().build();
		HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());

		ObjectMapper mapper = new ObjectMapper();
		JsonNode newJson = mapper.readValue(res.body(), JsonNode.class);
		List<Books> booksList = new ArrayList<Books>();
		for (JsonNode node : newJson) {
			String id = node.get("id").toString().replace("\"", "");
			String bookname = node.get("name").toString().replace("\"", "");
			String date = node.get("dateadded").toString().replace("\"", "");
			String author = node.get("author").toString().replace("\"", "");

			booksList.add(new Books(Integer.parseInt(id), bookname, date, author));

		}
		return booksList;
	}

	public void postData(final Books book) throws IOException, InterruptedException {

		System.out.println("Object received by function "+book);

		String url = "http://localhost:8890/add";
		ObjectMapper mapper = new ObjectMapper();
		String json = null;

		HashMap<String, Object> values = new HashMap<String, Object>() {
			private static final long serialVersionUID = 1L;
			{
				put("id", book.getId());
				put("name", book.getName());
				put("dateadded", book.getDateadded());
				put("author", book.getAuthor());
			}
		};

		json = mapper.writeValueAsString(values);

		HttpRequest req = HttpRequest.newBuilder().uri(URI.create(url)).header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(json)).build();

		HttpClient client = HttpClient.newHttpClient();

		HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());

		System.out.println(res.body());

	}

	public List<Author> getAuthors() throws IOException, InterruptedException {

		String url = "http://localhost:8890/allauthors";

		HttpRequest req = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		HttpClient client = HttpClient.newBuilder().build();
		HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());

		ObjectMapper mapper = new ObjectMapper();
		JsonNode newJson = mapper.readValue(res.body(), JsonNode.class);

		List<Author> authorList = new ArrayList<Author>();

		for (JsonNode node : newJson) {
			String id = node.get("id").toString().replace("\"", "");
			String authorname = node.get("name").toString().replace("\"", "");

			System.out.println(authorname);

			authorList.add(new Author(Integer.parseInt(id), authorname));

		}

		return authorList;
	}

	public void editBookData(int id, Books book) throws IOException, InterruptedException {
		String url = "http://localhost:8890/books/" + id;
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(book);

		HttpRequest req = HttpRequest.newBuilder().uri(URI.create(url)).header("Content-Type", "application/json")
				.PUT(HttpRequest.BodyPublishers.ofString(json)).build();
		
		HttpClient client = HttpClient.newHttpClient();

		HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());

		System.out.println(res.body());
		
	}

	public void deleteBook(Integer id) throws IOException, InterruptedException {
		String url = "http://localhost:8890/deletebook/" + id;
		HttpRequest req = HttpRequest.newBuilder().uri(URI.create(url)).header("Content-Type", "application/json")
				.DELETE().build();

		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());

		System.out.println(res.body());
		
	}

}
