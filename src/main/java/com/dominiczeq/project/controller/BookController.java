package com.dominiczeq.project.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dominiczeq.project.entity.Author;
import com.dominiczeq.project.entity.Book;
import com.dominiczeq.project.entity.Genre;
import com.dominiczeq.project.entity.Publisher;
import com.dominiczeq.project.repository.AuthorRepository;
import com.dominiczeq.project.repository.BookRepository;
import com.dominiczeq.project.repository.GenreRepository;
import com.dominiczeq.project.repository.PublisherRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepo;

	@Autowired
	private AuthorRepository authorRepo;

	@Autowired
	private GenreRepository genreRepo;

	@Autowired
	private PublisherRepository pubRepo;

	@GetMapping("/addBook")
	public String addBook(Model m) {
		m.addAttribute("book", new Book());
		return "book/addBook";
	}

	@PostMapping("/addBook")
	public String addAuthor(@Valid @ModelAttribute Book book, BindingResult bindingResult) 
			throws UnsupportedEncodingException {
		if (bindingResult.hasErrors()) {
			return "book/addBook";
		}
		this.bookRepo.save(book);
		return "redirect:/allBooks";
	}

	@GetMapping("/allBooks")
	public String showAllBooks() {
		return "book/allBooks";
	}

	@ModelAttribute("allBooks")
	public List<Book> getAllBooks() {
		return this.bookRepo.findAll();
	}

	@ModelAttribute("availableAuthors")
	public List<Author> getAllAuthors() {
		return this.authorRepo.findAll();
	}

	@ModelAttribute("availablePublishers")
	public List<Publisher> getAllPublishers() {
		return this.pubRepo.findAll();
	}

	@ModelAttribute("availableGenres")
	public List<Genre> getAllGenres() {
		return this.genreRepo.findAll();
	}

}
