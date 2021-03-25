package com.example.cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Film {

    @JsonIgnoreProperties(allowGetters = true)
    private Long id;
    private String titre;
    private String description;
    private Set<Actor> actors = new HashSet<>();
}