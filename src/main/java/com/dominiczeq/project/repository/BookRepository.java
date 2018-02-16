package com.dominiczeq.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dominiczeq.project.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
