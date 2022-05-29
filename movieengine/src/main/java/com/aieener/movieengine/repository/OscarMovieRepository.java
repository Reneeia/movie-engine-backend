package com.aieener.movieengine.repository;

import com.aieener.movieengine.daos.OscarMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OscarMovieRepository extends JpaRepository<OscarMovie, String> {
    List<OscarMovie> findBySeasonOfOscar(int season);

    List<OscarMovie> findByYearOfFilm(int yearOfFilm);

    List<OscarMovie> findByCategoryIn(List<String> categories);

    List<OscarMovie> findByMovieName(String movieName);

    List<OscarMovie> findBySeasonOfOscarAndIsWinner(int movieName, boolean isWinner);
}
