package com.dominiczeq.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.dominiczeq.project.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Modifying
	@Query(nativeQuery = true, value = "UPDATE user SET borrowedBooks=?1 WHERE id=?2")
	void setBorrowedBook(Integer borrowedBooks, Long userId);
	
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE user SET borrowedBooks=borrowedBooks - 1 WHERE id=?1")
	void decrementBorrowedBook(Long userId);


}
