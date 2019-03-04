package com.exemplo.zuulapp.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.zuulapp.security.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
