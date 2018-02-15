package com.dominiczeq.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.dominiczeq.project.entity.Publisher;


public interface PublisherRepository extends JpaRepository<Publisher, Long> {
	
	@Modifying
	@Query(nativeQuery=true, value="update publisher SET publisherName=?1 WHERE id=?2")
	void setUserInfoById(String publisherName, Long userId);
	
}
