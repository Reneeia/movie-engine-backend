package com.aieener.movieengine;

import com.aieener.movieengine.ops.OpsEngine;
import com.aieener.movieengine.repository.OscarMovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.security.Security;

@SpringBootApplication
public class MovieEngineApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieEngineApplication.class, args);
    }

    // inject initial oscar movie data from json to sqldb
//    @Bean
//    CommandLineRunner initDb(OscarMovieRepository movieRepo) {
//        return args -> OpsEngine.importOscarMovieDataToSqlDb(movieRepo);
//    }
}
