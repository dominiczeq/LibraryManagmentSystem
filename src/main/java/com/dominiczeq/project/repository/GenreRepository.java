package com.dominiczeq.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dominiczeq.project.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
