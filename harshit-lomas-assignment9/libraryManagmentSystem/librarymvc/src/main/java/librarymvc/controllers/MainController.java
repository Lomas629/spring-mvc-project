package librarymvc.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import librarymvc.model.Author;
import librarymvc.model.Books;
import librarymvc.model.Librarian;
import librarymvc.service.AuthorService;
import librarymvc.service.BookService;
import librarymvc.service.UserService;


@Controller
public class MainController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private BookService bookservice;
	
	@Autowired
	private AuthorService authorservice;

	@RequestMapping("/login")
	public String loginPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Librarian librarian = (Librarian) session.getAttribute("currentUser");
		
		if(librarian != null) return "redirect:/books";
		
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("currentUser");
		session.setAttribute("message", "You are Successfully logout !!!"); 
		session.invalidate();
		return "redirect:/login";
	}
	
	@RequestMapping("/books")
	public ModelAndView books(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException {
		HttpSession session = request.getSession();
		Librarian librarian = (Librarian) session.getAttribute("currentUser");
		
		if(librarian == null) {
			return new ModelAndView("redirect:/login");
		}
		
		ModelAndView model = new ModelAndView();
		List<Books> books = bookservice.fetchAllBooks();
		model.addObject("allBooks", books);
		model.setViewName("books");
		return model;
	}
	
	@RequestMapping("/addbook")
	public ModelAndView addBookPage(HttpServletRequest request) throws IOException, InterruptedException {
		
		HttpSession session = request.getSession();
		Librarian librarian = (Librarian) session.getAttribute("currentUser");
		
		if(librarian == null) {
			return new ModelAndView("redirect:/login");
		}
		
		ModelAndView model = new ModelAndView();
		
		Date currentDate = new Date();
		String dateTime = DateFormat.getDateInstance().format(currentDate);
		
		model.addObject("currentDate", dateTime);
		
		List<Author> authors = authorservice.getAllAuthors();
		model.addObject("allAuthors", authors);
		model.setViewName("addBookPage");
		return model;
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String addBook(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException {
		
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		String bookname = request.getParameter("bookname");
		String date = request.getParameter("date");
		String author = request.getParameter("author");
		
		System.out.println("Author "+author);
		
		Books book = new Books(bookid,bookname,date,author);
		
		this.bookservice.postData(book);
		
		return "redirect:/books";
	}

	
	@RequestMapping(path = "/loginUser", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException {
		
		HttpSession session = request.getSession();
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		Librarian user = new Librarian();
		user.setUsername(name);
		user.setPassword(password);
		
		boolean isExist = userservice.checkforUser(name,password);
		
		if (isExist==true) {
			session.setAttribute("currentUser", user);
			return "redirect:/books";
		}
		
		session.setAttribute("message", "Invalid User/Password");
		return "redirect:/login";
	}
	
	@RequestMapping("/editpage")
	public ModelAndView editPage(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException {
		ModelAndView model = new ModelAndView();
		
		String bookId = request.getParameter("id");
		int ID = Integer.parseInt(bookId);
		
		List<Books> books = bookservice.fetchAllBooks();
		for(Books book:books) {
			if(book.getId() == ID) {
				model.addObject("bookdetails", book);
				break;
			}
		}
		List<Author> authors = authorservice.getAllAuthors();
		model.addObject("allAuthors", authors);		
		model.setViewName("editpage");
		return model;
	}
	
	@RequestMapping(path="/edit/{id}",method=RequestMethod.POST)
	public String editBook(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException {
		
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		String bookname = request.getParameter("bookname");
		String date = request.getParameter("date");
		String author = request.getParameter("author");
		
		Books book = new Books(bookid,bookname,date,author);
		
		bookservice.editBookdetails(bookid,book);
		
		return "redirect:/books";
	}
	
	@RequestMapping(path="/delete/{id}",method=RequestMethod.POST)
	public String deleteBook(@PathVariable("id") Integer id) throws IOException, InterruptedException {
		bookservice.deleteBook(id);
		return "redirect:/books";
	}

}
