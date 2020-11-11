package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public class MovieInfo {
    private int id;
    private String name;
    private String genre;
    private float score;
    private int duration;
}

