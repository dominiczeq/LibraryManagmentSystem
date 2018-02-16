package com.dominiczeq.project.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.dominiczeq.project.entity.Author;
import com.dominiczeq.project.repository.AuthorRepository;

public class AuthorConverter implements Converter<String, Author> {

	@Autowired
	private AuthorRepository authorRepo;

	public Author convert(String source) {
		long id = Long.parseLong(source);
		Author author = this.authorRepo.findOne(id);
		return author;

	}

}
