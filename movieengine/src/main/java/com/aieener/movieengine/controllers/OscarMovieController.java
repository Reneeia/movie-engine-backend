package com.aieener.movieengine.controllers;

import com.aieener.movieengine.daos.OscarMovie;
import com.aieener.movieengine.services.OscarMovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class OscarMovieController {
    private final OscarMovieService service;

    public OscarMovieController(OscarMovieService service) {
        this.service = service;
    }

    @GetMapping(value="/oscar/{season}", produces = "application/json")
    public ResponseEntity<List<OscarMovie>> getOscarMovieBySeason(@PathVariable("season") Integer season) {
        List<OscarMovie> result = service.getByOscarSeason(season);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value="/oscar/{season}/winner", produces = "application/json")
    public ResponseEntity<List<OscarMovie>> getOscarWinnerMovieBySeason(@PathVariable("season") Integer season) {
        List<OscarMovie> result = service.getWinnerByOscarSeason(season);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
