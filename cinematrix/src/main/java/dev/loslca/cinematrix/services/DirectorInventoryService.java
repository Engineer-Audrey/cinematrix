package dev.loslca.cinematrix.services;

import dev.loslca.cinematrix.model.dto.DirectorDTO;
import dev.loslca.cinematrix.model.entity.Director;
import dev.loslca.cinematrix.repository.DirectorRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class DirectorInventoryService {

    private final DirectorRepository repository;

    public DirectorInventoryService(DirectorRepository repository) {
        this.repository = repository;
    }

    public List<Director> findAllDirectors() {
        return this.repository.findAll();
    }

    public List<Director> findDirectorsByName(String name) {
        return this.repository.findByNameContainingIgnoreCase(name);
    }

    public List<Director> findDirectorsByTrajectory(String trajectory) {
        return this.repository.findByTrajectoryContainingIgnoreCase(trajectory);
    }

    public DirectorDTO createDirector(DirectorDTO directorRequest) throws EntityNotFoundException {
        Director director = new Director();
        setAttributesFromDTO(directorRequest, director);
        this.repository.save(director);
        return directorRequest;
    }

    public DirectorDTO updateDirector(Long directorId, DirectorDTO directorRequest) throws EntityNotFoundException {
        Director director = this.repository.findById(directorId)
                .orElseThrow(() -> new EntityNotFoundException("Director with id " + directorId + " not found"));
        setAttributesFromDTO(directorRequest, director);
        this.repository.save(director);
        return directorRequest;
    }

    public void deleteDirector(Long directorId) throws EntityNotFoundException {
        Director director = this.repository.findById(directorId)
                .orElseThrow(() -> new EntityNotFoundException("Director with id " + directorId + " not found"));
        this.repository.delete(director);
    }

    public void setAttributesFromDTO(DirectorDTO request, Director director) {
        director.setName(request.name());
        director.setTrajectory(request.trajectory());
    }
}