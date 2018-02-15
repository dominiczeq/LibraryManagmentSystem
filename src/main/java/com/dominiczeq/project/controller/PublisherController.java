package com.dominiczeq.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dominiczeq.project.entity.Publisher;
import com.dominiczeq.project.repository.PublisherRepository;

@Controller
public class PublisherController {

	@Autowired
	private PublisherRepository pubRepo;

	@GetMapping("/addPublisher")
	public String addPublisher(Model m) {
		m.addAttribute("publisher", new Publisher());
		return "publisher/addPublisher";
	}

	@PostMapping("/addPublisher")
	public String addPublisher(@ModelAttribute Publisher publisher) {
		this.pubRepo.save(publisher);
		return "publisher/allPublishers";
	}

	@GetMapping("/allPublishers")
	public String showAllPublisher() {
		return "publisher/allPublishers";
	}

	@ModelAttribute("allPublishers")
	public List<Publisher> getAllPublishers() {
		return this.pubRepo.findAll();
	}

	@GetMapping("/publisher/{id}/del")
	public String deletePublisher(@PathVariable long id) {
		this.pubRepo.delete(id);
		return "redirect:/allPublishers";
	}

	@GetMapping("publisher/{id}/modify")
	public String modifyPublisher(@PathVariable long id, Model m) {
		Publisher p = this.pubRepo.findOne(id);
		m.addAttribute("publisher", p);
		return "publisher/addPublisher";
	}

	@Transactional
	@PostMapping("publisher/{id}/modify")
	public String modifyPublisher(@PathVariable long id, @ModelAttribute Publisher publisher) {
		this.pubRepo.setUserInfoById(publisher.getPublisherName(), id);
		return "redirect:/allPublishers";
	}
}
