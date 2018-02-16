package com.dominiczeq.project.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.dominiczeq.project.entity.Publisher;
import com.dominiczeq.project.repository.PublisherRepository;

public class PublisherConverter implements Converter<String, Publisher> {

	@Autowired
	private PublisherRepository pubRepo;

	public Publisher convert(String source) {
		long id = Long.parseLong(source);
		Publisher publisher = this.pubRepo.findOne(id);
		return publisher;
	}

}
