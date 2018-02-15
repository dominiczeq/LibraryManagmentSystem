package com.dominiczeq.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dominiczeq.project.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
