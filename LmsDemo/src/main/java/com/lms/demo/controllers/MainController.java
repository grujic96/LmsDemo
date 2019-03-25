package com.lms.demo.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lms.demo.models.Book;
import com.lms.demo.services.BookGenreService;
import com.lms.demo.services.LmsService;

@Controller
public class MainController {

	@Autowired
	private LmsService lmsService;
	
	@Autowired
	private BookGenreService bookGenreService;

	@GetMapping("/")
	public String init(HttpServletRequest req) {
		req.setAttribute("books", lmsService.findAllBooks());
		req.setAttribute("mode", "BOOK_VIEW");
		return "index";
	}

	@GetMapping("/updateBook")
	public String updateBook(@RequestParam int id, HttpServletRequest req) {
		req.setAttribute("book", lmsService.findBook(id));
		req.setAttribute("mode", "BOOK_EDIT");
		return "index";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), false));
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Book book, BindingResult bindingResult, HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		
		book.setBookGenre(bookGenreService.getGenreByName(req.getParameter("selectedBookGenre")));
		lmsService.save(book);
		req.setAttribute("mode", "BOOK_VIEW");
		resp.sendRedirect("/");
		return "index";
	}

	@GetMapping("/newBook")
	public String newBook(HttpServletRequest req) {
		req.setAttribute("mode", "BOOK_NEW");
		
		req.setAttribute("bookGenres",bookGenreService.getAllGenres());
		
		return "index";
	}

	@GetMapping("/delete")
	public void delete(@RequestParam int id, HttpServletRequest req,HttpServletResponse resp) throws IOException {
		lmsService.delete(id);
		resp.sendRedirect("/");
	}
	
	@PostMapping("/findBook")
	public String findBook(HttpServletRequest req){
		String author = req.getParameter("text1");
		Collection<Book> books = lmsService.findByAuthor(author);
		
		if (books.isEmpty()){
			req.setAttribute("mode", "BOOK_NOT_FOUND");
			req.setAttribute("books", "BOOK NOT FOUND");
			
		}
		else {
			req.setAttribute("mode", "BOOK_FOUND");
			req.setAttribute("books", books);

		}
		return "index";
	}
	
	
	
}
