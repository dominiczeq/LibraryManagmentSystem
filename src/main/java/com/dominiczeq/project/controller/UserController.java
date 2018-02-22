package com.dominiczeq.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dominiczeq.project.entity.User;
import com.dominiczeq.project.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@GetMapping("/addUser")
	public String addUser(Model m) {
		m.addAttribute("user", new User());
		return "user/addUser";
	}

	@PostMapping("/addUser")
	public String addAuthor(@ModelAttribute User user) {
		this.userRepo.save(user);
		return "redirect:/allUsers";
	}

	@GetMapping("/allUsers")
	public String showAllUsers() {
		return "user/allUsers";
	}

	@ModelAttribute("allUsers")
	public List<User> getAllUsers() {
		return this.userRepo.findAll();
	}

}
