package com.example.cinema;

import com.example.cinema.model.Film;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(value = FilmController.PATH_FILM_CONTROLLER)
@Slf4j
public class FilmController {
    public final static String PATH_FILM_CONTROLLER = "/api/film";

    private final FilmService service;
    private final String createUriPath;

    public FilmController(final FilmService service, final @Value("${info.app.baseUri}") String baseUri) {
        this.service = service;
        this.createUriPath = baseUri + PATH_FILM_CONTROLLER + "/";
    }

    @PostMapping
    ResponseEntity create(@RequestBody final Film film) {
        final Film filmPersisted = service.create(film);
        return ResponseEntity.created(buildPath(filmPersisted.getId())).body(filmPersisted);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity get(@PathVariable final Long id) {
        final Film film = service.get(id);
        return ResponseEntity.ok(film);
    }

    private URI buildPath(final Long id) {
        return URI.create(createUriPath + id);
    }
}
