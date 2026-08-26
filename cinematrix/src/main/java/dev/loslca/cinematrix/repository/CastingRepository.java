package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.Casting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CastingRepository extends JpaRepository<Casting, Long> {
}
