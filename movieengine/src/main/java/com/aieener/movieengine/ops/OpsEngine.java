package com.aieener.movieengine.ops;

import com.aieener.movieengine.daos.OscarMovie;
import com.aieener.movieengine.repository.OscarMovieRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OpsEngine {
    public static void importOscarMovieDataToSqlDb(OscarMovieRepository movieRepository){
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<OscarMovie>> typeReference = new TypeReference<List<OscarMovie>>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/the_oscar_award.json");
        try {
            List<OscarMovie> movies = objectMapper.readValue(inputStream, typeReference);
            movieRepository.saveAll(movies);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
