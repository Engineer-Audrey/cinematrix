package dev.loslca.cinematrix.services;

import dev.loslca.cinematrix.model.entity.Scene;
import dev.loslca.cinematrix.repository.SceneRepository;

import java.util.List;

public class SceneInventoryService {

    private final SceneRepository repository;

    public SceneInventoryService(SceneRepository repository) { this.repository = repository; }

    public List<Scene> findAllScenes() {
        return this.repository.findAll();
    }

    public List<Scene> findScenesByMovie(Long movieId) {
        return this.repository.findByMovieMovieId(movieId);
    }

    public List<Scene> findScenesByLocation(Long locationId) {
        return this.repository.findByLocationLocationId(locationId);
    }

    public List<Scene> findSceneByMovieAndNumber(Long movieId, Integer sceneNumber) {
        return this.repository.findByMovieMovieIdAndSceneNumber(movieId, sceneNumber);
    }
}