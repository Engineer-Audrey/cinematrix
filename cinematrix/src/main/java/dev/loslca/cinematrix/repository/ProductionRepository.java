package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.Production;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductionRepository extends JpaRepository<Production, Long> {
    public List<Production> findByMovieTitleContainingIgnoreCase(String title);
    public Optional<Production> findByMovieId(Long movieId);
    public List<Production> findByBudget(Double budget);
    public List<Production> findByActualCost(Double actualCost);
}