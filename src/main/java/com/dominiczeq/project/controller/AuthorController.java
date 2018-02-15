package com.dominiczeq.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dominiczeq.project.entity.Author;
import com.dominiczeq.project.repository.AuthorRepository;

@Controller
public class AuthorController {

	@Autowired
	private AuthorRepository authorRepo;

	@GetMapping("/addAuthor")
	public String addAuthor(Model m) {
		m.addAttribute("author", new Author());
		return "author/addAuthor";
	}

	@PostMapping("/addAuthor")
	public String addAuthor(@ModelAttribute Author author) {
		this.authorRepo.save(author);
		return "author/allAuthors";
	}

	@GetMapping("/allAuthors")
	public String showAllAuthors() {
		return "author/allAuthors";
	}

	@ModelAttribute("allAuthors")
	public List<Author> getAllAuthors() {
		return this.authorRepo.findAll();
	}

}
