package com.dominiczeq.project.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.dominiczeq.project.entity.LendBook;

public interface LendBookRepository extends JpaRepository<LendBook, Long> {

	List<LendBook> findAllByIsReturn(boolean bool);

	@Modifying
	@Query(nativeQuery = true, value = "UPDATE lendBook SET isReturn=1, returnBook=?1 WHERE id=?2")
	void setIsReturnEqual1AndreturnDate(LocalDate date, Long userId);

}
