package com.mymovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymovie.model.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {

}
