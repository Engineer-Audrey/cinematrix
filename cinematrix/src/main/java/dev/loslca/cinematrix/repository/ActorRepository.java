package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    public List<Actor> findByFirstNameContainingIgnoreCase(String firstName);
    public List<Actor> findByLastNameContainingIgnoreCase(String lastName);
    public List<Actor> findByNationality(String nationality);
}