package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
