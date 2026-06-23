package com.moviehub.service.movie;

import com.moviehub.model.dto.movie.MovieAddDTO;
import com.moviehub.model.entity.movie.Movie;
import com.moviehub.repository.movie.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public void addMovie(MovieAddDTO movieAddDTO) {
        Movie movie = new Movie();
        movie.setTitle(movieAddDTO.getTitle());
        movie.setDescription(movieAddDTO.getDescription());
        movie.setReleaseDate(movieAddDTO.getReleaseDate());

        movieRepository.save(movie);
    }

    public void deleteMovie(UUID id) {
        movieRepository.deleteById(id);
    }


}