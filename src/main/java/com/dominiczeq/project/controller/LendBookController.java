package com.dominiczeq.project.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dominiczeq.project.entity.Book;
import com.dominiczeq.project.entity.LendBook;
import com.dominiczeq.project.entity.User;
import com.dominiczeq.project.repository.BookRepository;
import com.dominiczeq.project.repository.LendBookRepository;
import com.dominiczeq.project.repository.UserRepository;

@Controller
public class LendBookController {

	@Autowired
	private BookRepository bookRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private LendBookRepository lendBookRepo;

	@GetMapping("/lendBook")
	public String rentBook(Model m) {
		m.addAttribute("lendBook", new LendBook());
		return "lendBook/lendBook";

	}

	@Transactional
	@PostMapping("/lendBook")
	public String rentBook(@ModelAttribute LendBook lendBook) {
		lendBook.setLendDate(LocalDate.now());
		lendBook.setReturnBook(LocalDate.now().plusDays(20));
		long bookAmount = lendBook.getBook().getAmount();
		int boorowedBook = lendBook.getUser().getBorrowedBooks();
		if (bookAmount > 0) {

			long id = lendBook.getBook().getId();
			this.bookRepo.setAmountBook(bookAmount - 1, id);
			this.userRepo.setBorrowedBook(boorowedBook + 1, lendBook.getUser().getId());
			this.lendBookRepo.save(lendBook);
			return "/home";
		} else {

			return "lendBook/noBook";
		}

	}

	@ModelAttribute("availableUsers")
	public List<User> getAllUsers() {
		return this.userRepo.findAll();
	}

	@ModelAttribute("availableBooks")
	public List<Book> getAllBooks() {
		return this.bookRepo.findAll();
	}

	@ModelAttribute("bookInLibrary")
	public List<Book> allBooksInLibrary() {
		return this.bookRepo.allBookInLibrary();
	}
}