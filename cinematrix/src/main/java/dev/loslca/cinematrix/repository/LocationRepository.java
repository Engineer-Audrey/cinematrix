package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Casting, Long> {
}
