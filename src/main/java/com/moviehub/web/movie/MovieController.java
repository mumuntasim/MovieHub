package com.moviehub.web.movie;

import com.moviehub.model.dto.movie.MovieAddDTO;
import com.moviehub.service.movie.MovieService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public String showMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "movies";
    }

    @GetMapping("/movies/add")
    public String addMovie(Model model) {
        if (!model.containsAttribute("movieAddDTO")) {
            model.addAttribute("movieAddDTO", new MovieAddDTO());
        }
        return "add-movie";
    }

    @PostMapping("/movies/add")
    public String addMovieConfirm(@Valid @ModelAttribute("movieAddDTO") MovieAddDTO movieAddDTO,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("movieAddDTO", movieAddDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.movieAddDTO", bindingResult);
            return "redirect:/movies/add";
        }

        movieService.addMovie(movieAddDTO);
        return "redirect:/movies";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @PostMapping("/movies/delete/{id}")
    public String deleteMovie(@PathVariable UUID id) {
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }
}