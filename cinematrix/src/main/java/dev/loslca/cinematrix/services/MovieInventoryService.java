package dev.loslca.cinematrix.services;

import dev.loslca.cinematrix.model.dto.MovieDTO;
import dev.loslca.cinematrix.model.entity.Director;
import dev.loslca.cinematrix.model.entity.Movie;
import dev.loslca.cinematrix.model.entity.Production;
import dev.loslca.cinematrix.repository.DirectorRepository;
import dev.loslca.cinematrix.repository.MovieRepository;
import dev.loslca.cinematrix.repository.ProductionRepository;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDate;
import java.util.List;

public class MovieInventoryService {

    private final MovieRepository repository;
    private final DirectorRepository directorRepository;
    private final ProductionRepository productionRepository;

    public MovieInventoryService(MovieRepository repository,
                                 DirectorRepository directorRepository,
                                 ProductionRepository productionRepository) {
        this.repository = repository;
        this.directorRepository = directorRepository;
        this.productionRepository = productionRepository;
    }

    public List<Movie> findAllMovies() {
        return this.repository.findAll();
    }

    public List<Movie> findMoviesByTitle(String title) {
        return this.repository.findByTitleContainingIgnoreCase(title);
    }

    public List<Movie> findMoviesBySynopsis(String synopsis) {
        return this.repository.findBySynopsisContainingIgnoreCase(synopsis);
    }

    public List<Movie> findMoviesByDurationMinutes(Integer durationMinutes) {
        return this.repository.findByDurationMinutes(durationMinutes);
    }

    public List<Movie> findMoviesByReleaseDate(LocalDate releaseDate) {
        return this.repository.findByReleaseDate(releaseDate);
    }

    public List<Movie> findMoviesByGenre(String genre) {
        return this.repository.findByGenre(genre.toUpperCase());
    }

    public List<Movie> findMoviesByDirectorId(Long directorId) {
        return this.repository.findByDirectorId(directorId);
    }

    public List<Movie> findMoviesByDirectorName(String name) {
        return this.repository.findByDirectorNameContainingIgnoreCase(name);
    }

    public List<Movie> findMoviesByProductionId(Long productionId) {
        return this.repository.findByProductionId(productionId);
    }

    public MovieDTO createMovie(MovieDTO movieRequest) throws EntityNotFoundException {
        Director director = findDirector(movieRequest.directorId());
        Production production = findProduction(movieRequest.productionId());
        Movie movie = new Movie();
        setAttributesFromDTO(movieRequest, movie, director, production);
        this.repository.save(movie);
        if (production != null) {
            // Production owns the @OneToOne foreign key (movie_id), so it must be
            // persisted after the Movie row is inserted to correctly link them.
            this.productionRepository.save(production);
        }
        return movieRequest;
    }

    public MovieDTO updateMovie(Long movieId, MovieDTO movieRequest) throws EntityNotFoundException {
        Movie movie = this.repository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie with id " + movieId + " not found"));
        Director director = findDirector(movieRequest.directorId());
        Production production = findProduction(movieRequest.productionId());
        setAttributesFromDTO(movieRequest, movie, director, production);
        this.repository.save(movie);
        if (production != null) {
            // Production owns the @OneToOne foreign key (movie_id), so it must be
            // persisted after the Movie row is inserted to correctly link them.
            this.productionRepository.save(production);
        }
        return movieRequest;
    }

    public void deleteMovie(Long movieId) throws EntityNotFoundException {
        Movie movie = this.repository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie with id " + movieId + " not found"));
        this.repository.delete(movie);
    }

    public void setAttributesFromDTO(MovieDTO request, Movie movie, Director director, Production production) {
        movie.setTitle(request.title());
        movie.setSynopsis(request.synopsis());
        movie.setDurationMinutes(request.durationMinutes());
        movie.setReleaseDate(request.releaseDate());
        movie.setGenre(request.genre());
        movie.setDirector(director);
        if (production != null) {
            production.setMovie(movie);
            movie.setProduction(production);
        }
    }

    public Director findDirector(Long directorId) throws EntityNotFoundException {
        if (directorId == null) {
            return null;
        }
        return this.directorRepository.findById(directorId)
                .orElseThrow(() -> new EntityNotFoundException("Director with id " + directorId + " not found"));
    }

    public Production findProduction(Long productionId) throws EntityNotFoundException {
        if (productionId == null) {
            return null;
        }
        return this.productionRepository.findById(productionId)
                .orElseThrow(() -> new EntityNotFoundException("Production with id " + productionId + " not found"));
    }
}