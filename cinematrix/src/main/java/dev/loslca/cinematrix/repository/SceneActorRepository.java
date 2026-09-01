package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.SceneActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SceneActorRepository extends JpaRepository<SceneActor, Long> {
    public List<SceneActor> findBySceneSceneId(Long sceneId);
    public List<SceneActor> findByActorActorId(Long actorId);
    public List<SceneActor> findByDirectorUserId(Long directorId);
}