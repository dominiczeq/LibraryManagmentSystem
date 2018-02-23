package com.dominiczeq.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(min=3, message="Imię jest zbyt krótkie")
	private String name;
	
	@Size(min=3, message="Nazwisko jest zbyt krótkie")
	private String surname;
	
	@Email(message="Niewłaściwy adres email")
	private String email;
	
	@Size(min=9, max=12, message="Numer telefonu musi się składać z 9 do 12 cyfr")
	private String phoneNumber;
	
	private int borrowedBooks;

	public User() {
		super();
	}

	public User(long id, String name, String surname, String email, String phoneNumber, int borrowedBooks) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.borrowedBooks = borrowedBooks;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(int borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}
	
	public String getFullName() {
		return name + " " + surname;
	}

	@Override
	public String toString() {
		return name + " " + surname;
	}

}
