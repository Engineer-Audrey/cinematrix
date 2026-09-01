package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.Scene;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SceneRepository extends JpaRepository<Scene, Long> {
    public List<Scene> findByMovieMovieId(Long movieId);
    public List<Scene> findByLocationLocationId(Long locationId);
    public List<Scene> findByMovieMovieIdAndSceneNumber(Long movieId, Integer sceneNumber);
}