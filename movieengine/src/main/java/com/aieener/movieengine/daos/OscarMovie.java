package com.aieener.movieengine.daos;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class OscarMovie {
    @Id
    private String id;

    private Integer yearOfFilm;

    private Integer yearOfOscar;

    private Integer seasonOfOscar;

    private String category;

    @Column(columnDefinition = "text")
    private String candidate;

    @Column(columnDefinition = "text")
    private String movieName;

    private String movieId;

    private Boolean isWinner;
}
