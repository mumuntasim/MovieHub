package com.moviehub.init;


import com.moviehub.model.entity.genre.Genre;
import com.moviehub.repository.genre.GenreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final GenreRepository genreRepository;

    public DataInitializer(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (genreRepository.count() == 0) {
            List<Genre> genres = List.of(
                    new Genre("Action"),
                    new Genre("Comedy"),
                    new Genre("Drama"),
                    new Genre("Horror"),
                    new Genre("Sci-Fi")
            );
            genreRepository.saveAll(genres);
            System.out.println("Genres initialized!");
        }
    }
}