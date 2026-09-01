package dev.loslca.cinematrix.services;

import dev.loslca.cinematrix.model.entity.SceneActor;
import dev.loslca.cinematrix.repository.SceneActorRepository;

import java.util.List;

public class SceneActorInventoryService {

    private final SceneActorRepository repository;

    public SceneActorInventoryService(SceneActorRepository repository) { this.repository = repository; }

    public List<SceneActor> findAllSceneActors() {
        return this.repository.findAll();
    }

    public List<SceneActor> findSceneActorsByScene(Long sceneId) {
        return this.repository.findBySceneSceneId(sceneId);
    }

    public List<SceneActor> findSceneActorsByActor(Long actorId) {
        return this.repository.findByActorActorId(actorId);
    }

    public List<SceneActor> findSceneActorsByDirector(Long directorId) {
        return this.repository.findByDirectorUserId(directorId);
    }
}