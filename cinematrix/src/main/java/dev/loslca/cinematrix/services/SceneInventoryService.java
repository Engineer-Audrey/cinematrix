package dev.loslca.cinematrix.services;

import dev.loslca.cinematrix.model.constant.TimeOfDay;
import dev.loslca.cinematrix.model.dto.SceneDTO;
import dev.loslca.cinematrix.model.entity.Location;
import dev.loslca.cinematrix.model.entity.Movie;
import dev.loslca.cinematrix.model.entity.Scene;
import dev.loslca.cinematrix.repository.LocationRepository;
import dev.loslca.cinematrix.repository.MovieRepository;
import dev.loslca.cinematrix.repository.SceneRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class SceneInventoryService {

    private final SceneRepository repository;
    private final MovieRepository movieRepository;
    private final LocationRepository locationRepository;

    public SceneInventoryService(SceneRepository repository,
                                 MovieRepository movieRepository,
                                 LocationRepository locationRepository) {
        this.repository = repository;
        this.movieRepository = movieRepository;
        this.locationRepository = locationRepository;
    }

    public List<Scene> findAllScenes() {
        return this.repository.findAll();
    }

    public List<Scene> findScenesBySceneNumber(Integer sceneNumber) {
        return this.repository.findBySceneNumber(sceneNumber);
    }

    public List<Scene> findScenesByDescription(String description) {
        return this.repository.findByDescriptionContainingIgnoreCase(description);
    }

    public List<Scene> findScenesByTimeOfDay(TimeOfDay timeOfDay) {
        return this.repository.findByTimeOfDay(timeOfDay);
    }

    public List<Scene> findScenesByMovieId(Long movieId) {
        return this.repository.findByMovieId(movieId);
    }

    public List<Scene> findScenesByMovieTitle(String title) {
        return this.repository.findByMovieTitleContainingIgnoreCase(title);
    }

    public List<Scene> findScenesByLocationId(Long locationId) {
        return this.repository.findByLocationId(locationId);
    }

    public List<Scene> findScenesByLocationCity(String city) {
        return this.repository.findByLocationCityContainingIgnoreCase(city);
    }

    public List<Scene> findScenesByLocationCountry(String country) {
        return this.repository.findByLocationCountryContainingIgnoreCase(country);
    }

    public SceneDTO createScene(SceneDTO sceneRequest) throws EntityNotFoundException {
        Movie movie = findMovie(sceneRequest.movieId());
        Location location = findLocation(sceneRequest.locationId());
        Scene scene = new Scene();
        setAttributesFromDTO(sceneRequest, scene, movie, location);
        this.repository.save(scene);
        return sceneRequest;
    }

    public SceneDTO updateScene(Long sceneId, SceneDTO sceneRequest) throws EntityNotFoundException {
        Scene scene = this.repository.findById(sceneId)
                .orElseThrow(() -> new EntityNotFoundException("Scene with id " + sceneId + " not found"));
        Movie movie = findMovie(sceneRequest.movieId());
        Location location = findLocation(sceneRequest.locationId());
        setAttributesFromDTO(sceneRequest, scene, movie, location);
        this.repository.save(scene);
        return sceneRequest;
    }

    public void deleteScene(Long sceneId) throws EntityNotFoundException {
        Scene scene = this.repository.findById(sceneId)
                .orElseThrow(() -> new EntityNotFoundException("Scene with id " + sceneId + " not found"));
        this.repository.delete(scene);
    }

    public void setAttributesFromDTO(SceneDTO request, Scene scene, Movie movie, Location location) {
        scene.setSceneNumber(request.sceneNumber());
        scene.setDescription(request.description());
        scene.setTimeOfDay(request.timeOfDay());
        scene.setMovie(movie);
        scene.setLocation(location);
    }

    public Movie findMovie(Long movieId) throws EntityNotFoundException {
        if (movieId == null) {
            return null;
        }
        return this.movieRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie with id " + movieId + " not found"));
    }

    public Location findLocation(Long locationId) throws EntityNotFoundException {
        if (locationId == null) {
            return null;
        }
        return this.locationRepository.findById(locationId)
                .orElseThrow(() -> new EntityNotFoundException("Location with id " + locationId + " not found"));
    }
}