package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.Movie;
import dev.loslca.cinematrix.model.constant.MovieStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    public List<Movie> findByTitleContainingIgnoreCase(String title);
    public List<Movie> findByGenre(String genre);
    public List<Movie> findByStatus(MovieStatus status);
    public List<Movie> findByProductionProductionId(Long productionId);
    public List<Movie> findByDirectorUserId(Long directorId);
}