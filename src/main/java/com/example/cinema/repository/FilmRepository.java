package com.example.cinema.repository;

import com.example.cinema.exception.NotFoundException;
import com.example.cinema.model.Film;
import com.example.cinema.repository.model.FilmDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class FilmRepository {

    private final JpaFilmRepository jpaRepository;

    public FilmRepository(JpaFilmRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public Film create(final Film film) {
        final FilmDao filmToSave = FilmMapper.MAPPER.toFilmDao(film);
        final FilmDao filmPersisted = jpaRepository.save(filmToSave);
        return FilmMapper.MAPPER.fromFilmDao(filmPersisted);
    }

    public Film get(final Long id) {
        return FilmMapper.MAPPER
                         .fromFilmDao(jpaRepository.findById(id)
                                                   .orElseThrow(() -> new NotFoundException("Film with id %s not found",
                                                                                            id)));
    }
}
