package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.constant.TimeOfDay;
import dev.loslca.cinematrix.model.entity.Scene;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SceneRepository extends JpaRepository<Scene, Long> {
    public List<Scene> findBySceneNumber(Integer sceneNumber);
    public List<Scene> findByDescriptionContainingIgnoreCase(String description);
    public List<Scene> findByTimeOfDay(TimeOfDay timeOfDay);
    public List<Scene> findByMovieId(Long movieId);
    public List<Scene> findByMovieTitleContainingIgnoreCase(String title);
    public List<Scene> findByLocationId(Long locationId);
    public List<Scene> findByLocationCityContainingIgnoreCase(String city);
    public List<Scene> findByLocationCountryContainingIgnoreCase(String country);
}