package com.mymovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymovie.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
