package com.example.cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class Actor {

    @JsonIgnoreProperties(allowGetters = true)
    private Long id;
    private String name;
    private String lastName;
}
