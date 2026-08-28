package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
