package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.ProductionCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductionCostRepository extends JpaRepository<ProductionCost, Long> {
    public List<ProductionCost> findByProductionProductionId(Long productionId);
    public List<ProductionCost> findByConceptContainingIgnoreCase(String concept);
}