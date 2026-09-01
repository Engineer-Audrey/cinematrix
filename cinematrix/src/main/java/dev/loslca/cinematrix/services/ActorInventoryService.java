package dev.loslca.cinematrix.services;

import dev.loslca.cinematrix.model.entity.Actor;
import dev.loslca.cinematrix.repository.ActorRepository;

import java.util.List;

public class ActorInventoryService {

    private final ActorRepository repository;

    public ActorInventoryService(ActorRepository repository) { this.repository = repository; }

    public List<Actor> findAllActors() {
        return this.repository.findAll();
    }

    public List<Actor> findActorsByFirstName(String firstName) {
        return this.repository.findByFirstNameContainingIgnoreCase(firstName);
    }

    public List<Actor> findActorsByLastName(String lastName) {
        return this.repository.findByLastNameContainingIgnoreCase(lastName);
    }

    public List<Actor> findActorsByNationality(String nationality) {
        return this.repository.findByNationality(nationality);
    }
}