package dev.loslca.cinematrix.services;

import dev.loslca.cinematrix.model.constant.MovieGenre;
import dev.loslca.cinematrix.model.dto.ActorDTO;
import dev.loslca.cinematrix.model.dto.MovieDTO;
import dev.loslca.cinematrix.model.dto.SceneDTO;
import dev.loslca.cinematrix.model.entity.Actor;
import dev.loslca.cinematrix.model.entity.Director;
import dev.loslca.cinematrix.model.entity.Location;
import dev.loslca.cinematrix.model.entity.Movie;
import dev.loslca.cinematrix.model.entity.Scene;
import dev.loslca.cinematrix.repository.ActorRepository;
import dev.loslca.cinematrix.repository.DirectorRepository;
import dev.loslca.cinematrix.repository.LocationRepository;
import dev.loslca.cinematrix.repository.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieInventoryService {

    private final MovieRepository repository;
    private final DirectorRepository directorRepository;
    private final ActorRepository actorRepository;
    private final LocationRepository locationRepository;

    public MovieInventoryService(MovieRepository repository,
                                 DirectorRepository directorRepository,
                                 ActorRepository actorRepository,
                                 LocationRepository locationRepository) {
        this.repository = repository;
        this.directorRepository = directorRepository;
        this.actorRepository = actorRepository;
        this.locationRepository = locationRepository;
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
        MovieGenre movieGenre = MovieGenre.valueOf(genre.toUpperCase());
        return this.repository.findByGenre(movieGenre);
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
        Director director = findDirector(movieRequest.director());
        Movie movie = new Movie();
        setAttributesFromDTO(movieRequest, movie, director);
        addScenes(movieRequest, movie);
        addActors(movieRequest, movie);
        this.repository.save(movie);
        return movieRequest;
    }

    public MovieDTO updateMovie(Long movieId, MovieDTO movieRequest) throws EntityNotFoundException {
        Movie movie = this.repository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie with id " + movieId + " not found"));
        Director director = findDirector(movieRequest.director());
        setAttributesFromDTO(movieRequest, movie, director);
        movie.getActors().clear();
        addActors(movieRequest, movie);
        this.repository.save(movie);
        return movieRequest;
    }

    public void deleteMovie(Long movieId) throws EntityNotFoundException {
        Movie movie = this.repository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie with id " + movieId + " not found"));
        this.repository.delete(movie);
    }

    public void setAttributesFromDTO(MovieDTO request, Movie movie, Director director) {
        movie.setTitle(request.title());
        movie.setSynopsis(request.synopsis());
        movie.setDurationMinutes(request.durationMinutes());
        movie.setReleaseDate(request.releaseDate());
        movie.setGenre(request.genre());
        movie.setDirector(director);
    }

    public void addScenes(MovieDTO request, Movie movie) {
        if (request.scenes() == null) {
            return;
        }
        for (SceneDTO sceneRequest : request.scenes()) {
            Location location = findLocation(sceneRequest.location());
            Scene scene = new Scene();
            scene.setSceneNumber(sceneRequest.sceneNumber());
            scene.setDescription(sceneRequest.description());
            scene.setTimeOfDay(sceneRequest.timeOfDay());
            scene.setLocation(location);
            movie.getScenes().add(scene);
        }
    }

    public void addActors(MovieDTO request, Movie movie) {
        if (request.actors() == null) {
            return;
        }
        for (ActorDTO actorRequest : request.actors()) {
            Actor actor = findActor(actorRequest.name());
            movie.getActors().add(actor);
        }
    }

    public Director findDirector(String directorName) throws EntityNotFoundException {
        if (directorName == null) {
            return null;
        }
        return this.directorRepository.findByNameIgnoreCase(directorName)
                .orElseThrow(() -> new EntityNotFoundException("Director with name " + directorName + " not found"));
    }

    public Actor findActor(String actorName) throws EntityNotFoundException {
        if (actorName == null) {
            return null;
        }
        return this.actorRepository.findByNameIgnoreCase(actorName)
                .orElseThrow(() -> new EntityNotFoundException("Actor with name " + actorName + " not found"));
    }

    public Location findLocation(String locationName) throws EntityNotFoundException {
        if (locationName == null) {
            return null;
        }
        return this.locationRepository.findByNameIgnoreCase(locationName)
                .orElseThrow(() -> new EntityNotFoundException("Location with name " + locationName + " not found"));
    }
}