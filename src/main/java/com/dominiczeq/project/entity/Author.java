package com.dominiczeq.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import javax.validation.constraints.Size;

@Entity
@Table(name = "author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(min=5, max=80, message="Pole musi zawierać między 5 a 80 znaków")
	private String authorName;

	public Author() {
		super();
	}

	public Author(long id, String authorName) {
		super();
		this.id = id;
		this.authorName = authorName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return authorName;
	}



}
