package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.Casting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CastingRepository extends JpaRepository<Casting, Long> {
    public List<Casting> findByMovieMovieId(Long movieId);
    public List<Casting> findByActorActorId(Long actorId);
    public List<Casting> findByLeadRole(Boolean leadRole);
}