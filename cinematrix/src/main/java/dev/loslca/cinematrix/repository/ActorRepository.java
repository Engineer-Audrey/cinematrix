package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Long> {
    public List<Actor> findByNameContainingIgnoreCase(String name);
    public List<Actor> findByNationalityContainingIgnoreCase(String nationality);
    public List<Actor> findByBirthDate(LocalDate birthDate);
}