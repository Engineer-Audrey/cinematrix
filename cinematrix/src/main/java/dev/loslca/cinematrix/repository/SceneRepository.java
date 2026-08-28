package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.Scene;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SceneRepository extends JpaRepository<Scene, Long> {
}
