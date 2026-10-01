package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DirectorRepository extends JpaRepository<Director, Long> {
    public List<Director> findByNameContainingIgnoreCase(String name);
    public List<Director> findByTrajectoryContainingIgnoreCase(String trajectory);
    public Optional<Director> findByNameIgnoreCase(String name);
}