package com.example.cinema.repository;

import com.example.cinema.model.Actor;
import com.example.cinema.model.Film;
import com.example.cinema.repository.model.ActorDao;
import com.example.cinema.repository.model.FilmDao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FilmMapper {
    FilmMapper MAPPER = Mappers.getMapper(FilmMapper.class);

    FilmDao toFilmDao(Film film);

    Film fromFilmDao(FilmDao filmDao);

    ActorDao toActorDao(Actor actor);

    Actor fromActorDao(ActorDao actorDao);
}
