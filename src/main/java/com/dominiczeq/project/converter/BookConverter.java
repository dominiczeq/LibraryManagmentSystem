package com.dominiczeq.project.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.dominiczeq.project.entity.Book;
import com.dominiczeq.project.repository.BookRepository;

public class BookConverter implements Converter<String, Book> {
	
	@Autowired
	private BookRepository bookRepo;

	public Book convert(String source) {
		Long id = Long.parseLong(source);
		Book book = this.bookRepo.findOne(id);
		return book;
	}

}
