package com.moviehub.service.movie;

import com.moviehub.model.dto.movie.MovieAddDTO;
import com.moviehub.model.entity.genre.Genre;
import com.moviehub.model.entity.movie.Movie;
import com.moviehub.repository.genre.GenreRepository;
import com.moviehub.repository.movie.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;

    public MovieService(MovieRepository movieRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public void addMovie(MovieAddDTO movieAddDTO) {
        Movie movie = new Movie();
        movie.setTitle(movieAddDTO.getTitle());
        movie.setDescription(movieAddDTO.getDescription());
        movie.setReleaseDate(movieAddDTO.getReleaseDate());

        Genre genre = genreRepository.findById(movieAddDTO.getGenreId())
                .orElseThrow(() -> new IllegalArgumentException("Genre not found with ID: " + movieAddDTO.getGenreId()));

        movie.setGenre(genre);

        movieRepository.save(movie);
    }

    public void deleteMovie(UUID id) {
        movieRepository.deleteById(id);
    }
}