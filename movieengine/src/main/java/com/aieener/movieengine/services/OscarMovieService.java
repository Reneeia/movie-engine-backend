package com.aieener.movieengine.services;

import com.aieener.movieengine.daos.OscarMovie;
import com.aieener.movieengine.repository.OscarMovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OscarMovieService {
    private final OscarMovieRepository repo;

    public OscarMovieService (OscarMovieRepository repo) {
        this.repo = repo;
    }

    public List<OscarMovie> getByOscarSeason(int season){
        return repo.findBySeasonOfOscar(season);
    }

    public List<OscarMovie> getWinnerByOscarSeason(int season){
        return repo.findBySeasonOfOscarAndIsWinner(season, true);
    }
}
