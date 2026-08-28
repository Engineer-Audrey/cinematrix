package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.Production;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionRepository extends JpaRepository<Production, Long> {
}
