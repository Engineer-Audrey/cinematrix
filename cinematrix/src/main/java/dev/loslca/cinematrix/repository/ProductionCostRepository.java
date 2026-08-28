package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.ProductionCost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionCostRepository extends JpaRepository<ProductionCost, Long> {
}
