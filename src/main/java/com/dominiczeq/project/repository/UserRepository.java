package com.dominiczeq.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dominiczeq.project.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}