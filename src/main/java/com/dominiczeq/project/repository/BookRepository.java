package com.dominiczeq.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.dominiczeq.project.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	@Modifying
	@Query(nativeQuery = true, value = "UPDATE book SET amount=?1 WHERE id=?2")
	void setAmountBook(Long amount, Long userId);

	@Query(nativeQuery = true, value = "SELECT * FROM book WHERE amount>0")
	List<Book> allBookInLibrary();

}
