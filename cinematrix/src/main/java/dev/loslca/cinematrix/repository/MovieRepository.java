package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.constant.MovieGenre;
import dev.loslca.cinematrix.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    public List<Movie> findByTitleContainingIgnoreCase(String title);
    public List<Movie> findBySynopsisContainingIgnoreCase(String synopsis);
    public List<Movie> findByDurationMinutes(Integer durationMinutes);
    public List<Movie> findByReleaseDate(LocalDate releaseDate);
    public List<Movie> findByGenre(MovieGenre genre);
    public List<Movie> findByDirectorId(Long directorId);
    public List<Movie> findByDirectorNameContainingIgnoreCase(String name);
    public List<Movie> findByProductionId(Long productionId);
    public List<Movie> findByActorsId(Long actorId);
    public Optional<Movie> findByTitleIgnoreCase(String title);
}