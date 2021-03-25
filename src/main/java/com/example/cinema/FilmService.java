package com.example.cinema;

import com.example.cinema.model.Film;
import com.example.cinema.repository.FilmRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FilmService {

    private final FilmRepository repository;

    public FilmService(FilmRepository repository) {
        this.repository = repository;
    }

    public Film create(final Film film) {
        return repository.create(film);
    }

    public Film get(final Long id) {
        return repository.get(id);
    }
}
