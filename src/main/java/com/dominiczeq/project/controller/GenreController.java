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

import com.dominiczeq.project.entity.Genre;
import com.dominiczeq.project.repository.GenreRepository;

@Controller
public class GenreController {
	
	@Autowired
	private GenreRepository genreRepo;

	@GetMapping("/addGenre")
	public String addGenre(Model m) {
		m.addAttribute("genre", new Genre());
		return "genre/addGenre";
	}
	
	@PostMapping("/addGenre")
	public String addGenre(@Valid @ModelAttribute Genre genre, BindingResult bindingResult) 
			throws UnsupportedEncodingException {
		if (bindingResult.hasErrors()) {
			return "genre/addGenre";
		}
		this.genreRepo.save(genre);
		return "redirect:/allGenres";
	}
	
	@GetMapping("/allGenres")
	public String showAllGenres() {
		return "genre/allGenres";
	}
	
	@ModelAttribute("allGenres")
	public List<Genre> allGenres() {
		return this.genreRepo.findAll();
	}
	

}
