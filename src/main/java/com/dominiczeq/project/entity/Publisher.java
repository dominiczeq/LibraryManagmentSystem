package com.dominiczeq.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "publisher")
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(min=3, max=40, message="Pole musi zawierać między 3 a 40 znaków")
	private String publisherName;

	public Publisher() {
		super();
	}

	public Publisher(long id, String publisherName) {
		super();
		this.id = id;
		this.publisherName = publisherName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	@Override
	public String toString() {
		return publisherName;
	}

}
