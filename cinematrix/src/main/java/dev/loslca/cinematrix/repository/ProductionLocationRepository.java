package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.ProductionLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionLocationRepository extends JpaRepository<ProductionLocation, Long> {
}
