package com.dominiczeq.project.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.dominiczeq.project.entity.User;
import com.dominiczeq.project.repository.UserRepository;

public class UserConverter implements Converter<String, User>{

	@Autowired
	private UserRepository userRepo;
	
	public User convert(String source) {
		User user = this.userRepo.findOne(Long.parseLong(source));
		return user;
	}

}
