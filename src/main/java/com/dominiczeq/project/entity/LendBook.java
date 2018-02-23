package com.dominiczeq.project.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lendBook")
public class LendBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private LocalDate lendDate;

	private LocalDate returnBook;

	private boolean isReturn = false;

	public LendBook() {
		super();
	}

	public LendBook(long id, Book book, User user) {
		super();
		this.id = id;
		this.book = book;
		this.user = user;
		this.lendDate = LocalDate.now();
		this.returnBook = LocalDate.now().plusDays(30);

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getLendDate() {
		return lendDate;
	}

	public void setLendDate(LocalDate lendDate) {
		this.lendDate = lendDate;
	}

	public LocalDate getReturnBook() {
		return returnBook;
	}

	public void setReturnBook(LocalDate returnBook) {
		this.returnBook = returnBook;
	}

	public boolean isReturn() {
		return isReturn;
	}

	public void setReturn(boolean isReturn) {
		this.isReturn = isReturn;
	}

}
