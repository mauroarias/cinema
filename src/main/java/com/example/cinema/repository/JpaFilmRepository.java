package com.example.cinema.repository;


import com.example.cinema.repository.model.FilmDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaFilmRepository extends JpaRepository<FilmDao, Long> {
}
