package dev.loslca.cinematrix.services;

import dev.loslca.cinematrix.model.entity.Movie;
import dev.loslca.cinematrix.model.constant.MovieStatus;
import dev.loslca.cinematrix.repository.MovieRepository;

import java.util.List;

public class MovieInventoryService {

    private final MovieRepository repository;

    public MovieInventoryService(MovieRepository repository) { this.repository = repository; }

    public List<Movie> findAllMovies() {
        return this.repository.findAll();
    }

    public List<Movie> findMoviesByTitle(String title) {
        return this.repository.findByTitleContainingIgnoreCase(title);
    }

    public List<Movie> findMoviesByGenre(String genre) {
        return this.repository.findByGenre(genre);
    }

    public List<Movie> findMoviesByStatus(MovieStatus status) {
        return this.repository.findByStatus(status);
    }

    public List<Movie> findMoviesByProduction(Long productionId) {
        return this.repository.findByProductionProductionId(productionId);
    }

    public List<Movie> findMoviesByDirector(Long directorId) {
        return this.repository.findByDirectorUserId(directorId);
    }
}