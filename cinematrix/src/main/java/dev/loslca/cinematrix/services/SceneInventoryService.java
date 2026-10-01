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
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public List<Scene> findScenesByLocationId(Long locationId) {
        return this.repository.findByLocationId(locationId);
    }

    public List<Scene> findScenesByLocationCity(String city) {
        return this.repository.findByLocationCityContainingIgnoreCase(city);
    }

    public List<Scene> findScenesByLocationCountry(String country) {
        return this.repository.findByLocationCountryContainingIgnoreCase(country);
    }

    public SceneDTO createScene(String movieTitle, SceneDTO sceneRequest) throws EntityNotFoundException {
        Movie movie = this.movieRepository.findByTitleIgnoreCase(movieTitle)
                .orElseThrow(() -> new EntityNotFoundException("Movie with title " + movieTitle + " not found"));
        Location location = findLocation(sceneRequest.location());
        Scene scene = new Scene();
        setAttributesFromDTO(sceneRequest, scene, location);
        movie.getScenes().add(scene);
        this.movieRepository.save(movie);
        return sceneRequest;
    }

    public SceneDTO updateScene(Long sceneId, SceneDTO sceneRequest) throws EntityNotFoundException {
        Scene scene = this.repository.findById(sceneId)
                .orElseThrow(() -> new EntityNotFoundException("Scene with id " + sceneId + " not found"));
        Location location = findLocation(sceneRequest.location());
        setAttributesFromDTO(sceneRequest, scene, location);
        this.repository.save(scene);
        return sceneRequest;
    }

    public void deleteScene(Long sceneId) throws EntityNotFoundException {
        Scene scene = this.repository.findById(sceneId)
                .orElseThrow(() -> new EntityNotFoundException("Scene with id " + sceneId + " not found"));
        this.repository.delete(scene);
    }

    public void setAttributesFromDTO(SceneDTO request, Scene scene, Location location) {
        scene.setSceneNumber(request.sceneNumber());
        scene.setDescription(request.description());
        scene.setTimeOfDay(request.timeOfDay());
        scene.setLocation(location);
    }

    public Location findLocation(String locationName) throws EntityNotFoundException {
        if (locationName == null) {
            return null;
        }
        return this.locationRepository.findByNameIgnoreCase(locationName)
                .orElseThrow(() -> new EntityNotFoundException("Location with name " + locationName + " not found"));
    }
}