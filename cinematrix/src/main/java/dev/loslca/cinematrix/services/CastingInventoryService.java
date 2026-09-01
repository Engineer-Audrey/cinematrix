package dev.loslca.cinematrix.services;

import dev.loslca.cinematrix.model.entity.Casting;
import dev.loslca.cinematrix.repository.CastingRepository;

import java.util.List;

public class CastingInventoryService {

    private final CastingRepository repository;

    public CastingInventoryService(CastingRepository repository) { this.repository = repository; }

    public List<Casting> findAllCastings() {
        return this.repository.findAll();
    }

    public List<Casting> findCastingsByMovie(Long movieId) {
        return this.repository.findByMovieMovieId(movieId);
    }

    public List<Casting> findCastingsByActor(Long actorId) {
        return this.repository.findByActorActorId(actorId);
    }

    public List<Casting> findCastingsByLeadRole(Boolean leadRole) {
        return this.repository.findByLeadRole(leadRole);
    }
}