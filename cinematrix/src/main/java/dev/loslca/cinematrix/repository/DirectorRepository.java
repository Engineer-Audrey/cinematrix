package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectorRepository extends JpaRepository<Director, Long> {
    public List<Director> findByNameContainingIgnoreCase(String name);
    public List<Director> findByTrajectoryContainingIgnoreCase(String trajectory);
}