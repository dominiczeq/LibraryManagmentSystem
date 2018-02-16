package com.dominiczeq.project.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.dominiczeq.project.entity.Genre;
import com.dominiczeq.project.repository.GenreRepository;

public class GenreConverter implements Converter<String, Genre> {

	@Autowired
	private GenreRepository genreRepo;

	@Override
	public Genre convert(String source) {
		Long id = Long.parseLong(source);
		Genre genre = this.genreRepo.findOne(id);
		return genre;

	}

}
