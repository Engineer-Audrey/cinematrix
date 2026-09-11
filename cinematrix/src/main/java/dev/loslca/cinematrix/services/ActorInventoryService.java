package dev.loslca.cinematrix.services;

import dev.loslca.cinematrix.model.dto.ActorDTO;
import dev.loslca.cinematrix.model.entity.Actor;
import dev.loslca.cinematrix.repository.ActorRepository;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDate;
import java.util.List;

public class ActorInventoryService {

    private final ActorRepository repository;

    public ActorInventoryService(ActorRepository repository) {
        this.repository = repository;
    }

    public List<Actor> findAllActors() {
        return this.repository.findAll();
    }

    public List<Actor> findActorsByName(String name) {
        return this.repository.findByNameContainingIgnoreCase(name);
    }

    public List<Actor> findActorsByNationality(String nationality) {
        return this.repository.findByNationalityContainingIgnoreCase(nationality);
    }

    public List<Actor> findActorsByBirthDate(LocalDate birthDate) {
        return this.repository.findByBirthDate(birthDate);
    }

    public ActorDTO createActor(ActorDTO actorRequest) throws EntityNotFoundException {
        Actor actor = new Actor();
        setAttributesFromDTO(actorRequest, actor);
        this.repository.save(actor);
        return actorRequest;
    }

    public ActorDTO updateActor(Long actorId, ActorDTO actorRequest) throws EntityNotFoundException {
        Actor actor = this.repository.findById(actorId)
                .orElseThrow(() -> new EntityNotFoundException("Actor with id " + actorId + " not found"));
        setAttributesFromDTO(actorRequest, actor);
        this.repository.save(actor);
        return actorRequest;
    }

    public void deleteActor(Long actorId) throws EntityNotFoundException {
        Actor actor = this.repository.findById(actorId)
                .orElseThrow(() -> new EntityNotFoundException("Actor with id " + actorId + " not found"));
        this.repository.delete(actor);
    }

    public void setAttributesFromDTO(ActorDTO request, Actor actor) {
        actor.setName(request.name());
        actor.setNationality(request.nationality());
        actor.setBirthDate(request.birthDate());
    }
}