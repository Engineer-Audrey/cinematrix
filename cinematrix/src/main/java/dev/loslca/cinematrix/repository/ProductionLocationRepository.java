package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.ProductionLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductionLocationRepository extends JpaRepository<ProductionLocation, Long> {
    public List<ProductionLocation> findByProductionProductionId(Long productionId);
    public List<ProductionLocation> findByLocationLocationId(Long locationId);
}